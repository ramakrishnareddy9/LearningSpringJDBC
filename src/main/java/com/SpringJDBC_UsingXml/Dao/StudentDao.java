package com.SpringJDBC_UsingXml.Dao;

import com.SpringJDBC_UsingXml.Entites.Student;

import java.util.List;

public interface StudentDao {
    public void insertStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
