package com.example.Employee.emailsenderandotp.repository;

import com.example.Employee.emailsenderandotp.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentRespository extends MongoRepository<Student , String>
{
    @Query("{email : {$eq : ?0}} ")
    Student findByEmail(String email);
}
