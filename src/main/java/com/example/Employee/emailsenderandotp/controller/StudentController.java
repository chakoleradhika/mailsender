package com.example.Employee.emailsenderandotp.controller;

import com.example.Employee.emailsenderandotp.dto.StudentDto;
import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import com.example.Employee.emailsenderandotp.entity.Student;
import com.example.Employee.emailsenderandotp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController
{

    private final StudentService studentService;

    @PostMapping("/register")
    private ResponseEntity<ResponseStructure> registerStudent(@RequestBody StudentDto studentDto){
        return studentService.registerStudent(studentDto);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyStudent(@RequestParam String email , @RequestParam String otp){
        try{
            studentService.verify(email , otp);
            return new ResponseEntity<>("User Verified Suuceefully" , HttpStatus.OK);
        }catch(Exception e ){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
