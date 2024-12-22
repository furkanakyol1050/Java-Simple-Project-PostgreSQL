package com.example.sql_demo.services.impl;

import com.example.sql_demo.dto.DtoStudent;
import com.example.sql_demo.dto.DtoStudentIU;
import com.example.sql_demo.entities.Student;
import com.example.sql_demo.repository.StudentRepository;
import com.example.sql_demo.services.IStudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public DtoStudent saveStudent(DtoStudentIU student) {
        studentRepository.save(modelMapper.map(student, Student.class));
        return modelMapper.map(student, DtoStudent.class);
    }

    @Override
    public List<DtoStudent> getAllStudent() {
        return modelMapper.map(studentRepository.findAll(), new TypeToken<List<DtoStudent>>(){}.getType());
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.map(value -> modelMapper.map(value, DtoStudent.class)).orElse(null);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU student) {
        DtoStudent dbStudent = getStudentById(id);
        if(dbStudent != null){
            Student newStudent = modelMapper.map(dbStudent, Student.class);
            newStudent.setId(id);
            newStudent.setBirthOfDay(student.getBirthOfDay());
            newStudent.setName(student.getName());
            newStudent.setSurname(student.getSurname());
            studentRepository.save(newStudent);
            return modelMapper.map(student, DtoStudent.class);
        }
        return null;
    }
}
