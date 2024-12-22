package com.example.sql_demo.services;

import com.example.sql_demo.dto.DtoStudent;
import com.example.sql_demo.dto.DtoStudentIU;
import com.example.sql_demo.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudent();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU student);
}
