package com.example.Employee.emailsenderandotp.dao;

import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import com.example.Employee.emailsenderandotp.entity.Student;
import com.example.Employee.emailsenderandotp.repository.StudentRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class StudentDao {

    private final StudentRespository studentRespository;

    public Student getStudentByEmail(String email) {
        return studentRespository.findByEmail(email);
    }

    public Student registerStudent(Student stud) {
        return studentRespository.save(stud);
    }
}
