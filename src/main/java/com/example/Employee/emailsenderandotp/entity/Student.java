package com.example.Employee.emailsenderandotp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student
{
    @Id
    private String id;
    private String name ;
    private String email;
    private String otp ;
    private String Verified;

}
