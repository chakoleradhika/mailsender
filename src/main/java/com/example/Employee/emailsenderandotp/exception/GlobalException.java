package com.example.Employee.emailsenderandotp.exception;

import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import com.example.Employee.emailsenderandotp.utils.HttpResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException
{

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseStructure> filed(NullPointerException e){
        return HttpResponses.failed(e);
    }
}
