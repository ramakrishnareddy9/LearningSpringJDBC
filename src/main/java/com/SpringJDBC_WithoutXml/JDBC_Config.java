package com.SpringJDBC_WithoutXml;

import com.SpringJDBC_WithoutXml.Dao.StudentDao;
import com.SpringJDBC_WithoutXml.Dao.StudentImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.SpringJDBC_WithoutXml")
public class JDBC_Config {
    private final String password = "9014923870@Drkr";

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

//    we are either using this Method using @Bean annotation or we declare @Component annotation on the class StudentImp
//    @Bean
//    public StudentDao studentDao() {
//        StudentImp dao = new StudentImp();
//        dao.setJdbcTemplate(jdbcTemplate());
//        return dao;
//    }

}
