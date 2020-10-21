package com.example.springboot.controller;

import com.example.springboot.model.StudentEntity;
import com.example.springboot.model.TransactionEntity;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/get-all-students")
    public List<StudentEntity> getAllStudent(){
        List<StudentEntity> allEmployeelist = studentRepository.findAll();
        return allEmployeelist;
    }

    @GetMapping("/get-student/{id}")
    public StudentEntity getStudentbyId(@PathVariable(value = "id") Integer studentId)

    {
        StudentEntity studentEntity = studentRepository.findById(studentId).get();

        return studentEntity;
    }

    @PostMapping("/create-students")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {

        StudentEntity savedStudent = studentRepository.save(student);

        return savedStudent;
    }

    @PutMapping("/update-students/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value = "id") Integer studentId,
                                                        @RequestBody StudentEntity studentDetails) {
        StudentEntity student = studentRepository.findById(studentId).get();

        student.setEmailId(studentDetails.getEmailId());
        student.setName(studentDetails.getName());
        final StudentEntity updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete-students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Integer studentId)
    {
        StudentEntity student = studentRepository.findById(studentId).get();

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

