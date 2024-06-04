package com.example.Employee.emailsenderandotp.utils;

import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class HttpResponses
{

    public static ResponseEntity<ResponseStructure> created(Object object){

        ResponseStructure responseStructure = ResponseStructure.builder().httpStatusCode(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .data(object).build();
        return new ResponseEntity<ResponseStructure>(responseStructure , HttpStatus.CREATED);
    }

    public static ResponseEntity<ResponseStructure> failed(Exception e ){

        ResponseStructure responseStructure = ResponseStructure.builder().httpStatusCode(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .data(null).build();
        return new ResponseEntity<ResponseStructure>(responseStructure , HttpStatus.BAD_REQUEST);
    }


}
