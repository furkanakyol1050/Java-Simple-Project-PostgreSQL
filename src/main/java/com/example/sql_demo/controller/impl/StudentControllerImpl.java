package com.example.sql_demo.controller.impl;

import com.example.sql_demo.controller.IStudentController;
import com.example.sql_demo.dto.DtoStudent;
import com.example.sql_demo.dto.DtoStudentIU;
import com.example.sql_demo.entities.Student;
import com.example.sql_demo.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/getAll")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable Integer id,@RequestBody DtoStudentIU student) {
        return studentService.updateStudent(id, student);
    }
}
