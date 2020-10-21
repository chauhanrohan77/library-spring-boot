package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    public StudentEntity() {

    }

    public StudentEntity(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public Integer getStudentId() {
        return studentId;
    }
    public void setId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", emailId=" + emailId
                + "]";
    }

}