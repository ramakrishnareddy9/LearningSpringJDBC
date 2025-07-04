package com.SpringJDBC_WithoutXml.Dao;

import com.SpringJDBC_WithoutXml.Entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentImp implements StudentDao {

    @Autowired // only for @@Component if we are not using @bean annotation
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertStudent(Student student) {
        String query = "Insert into student (id, name, city) values (?,?,?)";
        this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
    }

    @Override
    public void updateStudent(Student student) {
        String query = "Update student set name = ?, city = ? where id = ?";
        this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
    }

    @Override
    public void deleteStudent(int id) {
        String query = "Delete from student where id = ?";
        this.jdbcTemplate.update(query, id);
    }
//    selecting single object from database
//    @Override
//    public Student getStudent(int id) {
//        String query = "Select * from student where id = ?";
//        RowMapper<Student> rowMapper = new RowMapperImp();
//        return this.jdbcTemplate.queryForObject(query, rowMapper, id);
//    }
//  we can use above method as well but instead of creating a new class RodMapperImp we are using anonymous class
    @Override
    public Student getStudent(int id) {
        String query = "Select * from student where id = ?";
        return (Student) this.jdbcTemplate.queryForObject(query, new RowMapper<Student>(){
            @Override
            public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setCity(rs.getString(3));
                return student;
            }
        }, id);
    }

//    @Override
//    public Student getStudent(int id) {
//        String query = "SELECT * FROM student WHERE id = ?";
//        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class), id);
//    }

//    selecting multiple objects from database
    @Override
    public List<Student> getAllStudents() {
        String query = "Select * from student";
        RowMapper<Student> rowMapper = new RowMapperImp();
        return this.jdbcTemplate.query(query, rowMapper);
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
