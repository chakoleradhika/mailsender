package com.example.Employee.emailsenderandotp.service;

import com.example.Employee.emailsenderandotp.controller.StudentController;
import com.example.Employee.emailsenderandotp.dao.StudentDao;
import com.example.Employee.emailsenderandotp.dto.StudentDto;
import com.example.Employee.emailsenderandotp.entity.ResponseStructure;
import com.example.Employee.emailsenderandotp.entity.Student;
import com.example.Employee.emailsenderandotp.utils.CommonUtil;
import com.example.Employee.emailsenderandotp.utils.HttpResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.Objects;
import java.util.Random;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements  StudentService{

    private final StudentDao studentDao;

   private final ModelMapper modelMapper;

    private final EmailSerivce emailSerivce;


    @Override
    public ResponseEntity<ResponseStructure> registerStudent(StudentDto studentDto) {

        Student student = studentDao.getStudentByEmail(studentDto.getEmail());

        if(Objects.isNull(student)){

            student = modelMapper.map(studentDto , Student.class);
            student.setVerified(CommonUtil.notVerified);
            String otp = generateOTP();
            student.setOtp(otp);
            student = studentDao.registerStudent(student);
            sendVerificationEmail(student.getEmail(),otp);
            return HttpResponses.created(student);
        }

        throw new NullPointerException("Student Already exsist");
    }

    @Override
    public void verify(String email, String otp) {
        Student student = studentDao.getStudentByEmail(email);
        if(Objects.isNull(student)){
            throw new NullPointerException("Student not Found");
        }else if(student.getVerified().equals(CommonUtil.Verified)){
            throw new NullPointerException("Student is already verified");
        }else if(otp.equals(student.getOtp())){
            student.setVerified(CommonUtil.Verified);
            studentDao.registerStudent(student);
        }else{
            throw new NullPointerException("Internal Server Error");
        }
    }

    private String generateOTP(){
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }

    private void sendVerificationEmail(String email , String otp){
        String subject="email is verification";
        String body = "your verification otp is "+otp;
        emailSerivce.sendEmail(email,subject,body);
    }
}
