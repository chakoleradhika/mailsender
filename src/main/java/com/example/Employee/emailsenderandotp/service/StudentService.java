package com.example.Employee.emailsenderandotp.service;

import com.example.Employee.emailsenderandotp.dto.StudentDto;
import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<ResponseStructure> registerStudent(StudentDto studentDto);

    void verify(String email, String otp);
}
