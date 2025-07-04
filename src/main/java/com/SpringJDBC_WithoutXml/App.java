package com.SpringJDBC_WithoutXml;


import com.SpringJDBC_WithoutXml.Dao.StudentDao;
import com.SpringJDBC_WithoutXml.Entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JDBC_Config.class);
        StudentDao studentDao = applicationContext.getBean("studentDao",StudentDao.class);

//        Student student = new Student(4,"Lakshman kaja","gtu");
//        studentDao.insertStudent(student);
//        System.out.println("Student inserted");

//        Student student = new Student(4,"Lakshman kaja","Gut");
//        studentDao.updateStudent(student);
//        System.out.println("Student updated");

//        Student student = new Student();
//        student.setId(5);
//        studentDao.deleteStudent(student.getId());
//        System.out.println("Student deleted");

//        Student student = studentDao.getStudent(1);
//        System.out.println(student);

        System.out.println("All Students");
        for(Student s:studentDao.getAllStudents()){
            System.out.println(s);
        }

    }
}

