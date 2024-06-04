package com.example.Employee.emailsenderandotp.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class StudentDto {

    private String id;
    private String name ;
    private String email;

}
