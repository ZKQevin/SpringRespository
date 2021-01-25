package org.example.dao;

import org.example.entity.Student;

import java.util.List;


public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudent();

}
