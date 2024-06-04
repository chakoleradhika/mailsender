package com.example.Employee.emailsenderandotp.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ResponseStructure
{
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private Object data;
}
