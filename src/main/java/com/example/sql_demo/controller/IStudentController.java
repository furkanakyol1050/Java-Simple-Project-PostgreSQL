package com.example.sql_demo.controller;

import com.example.sql_demo.dto.DtoStudent;
import com.example.sql_demo.dto.DtoStudentIU;
import com.example.sql_demo.entities.Student;

import java.util.List;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU student);
}
