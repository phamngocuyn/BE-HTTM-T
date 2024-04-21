package com.twd.SpringSecurityJWT.service.impl;

import com.twd.SpringSecurityJWT.dto.ReqRes;

import com.twd.SpringSecurityJWT.entity.OurUsers;
import com.twd.SpringSecurityJWT.exception.EmailExistsException;
import com.twd.SpringSecurityJWT.exception.UserNotFoundException;
import com.twd.SpringSecurityJWT.repository.OurUserRepo;
import com.twd.SpringSecurityJWT.util.JWTUtils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.thymeleaf.context.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private OurUserRepo ourUserRepo;
    
    @Autowired
    private JWTUtils jwtUtils;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private TemplateEngine templateEngine;

    public ReqRes signUp(ReqRes registrationRequest) {
        ReqRes resp = new ReqRes();

        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu hay không
        boolean userExists = ourUserRepo.findByEmail(registrationRequest.getEmail()).isPresent();
        if (userExists) {
        	throw new EmailExistsException("Email này đã tồn tại");
        }

        try {
            OurUsers ourUsers = new OurUsers();
            ourUsers.setEmail(registrationRequest.getEmail());
            ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
//            ourUsers.setRole(registrationRequest.getRole());
            ourUsers.setRole("USER");
            OurUsers ourUserResult = ourUserRepo.save(ourUsers);
            if (ourUserResult != null && ourUserResult.getId() > 0) {
                resp.setOurUsers(ourUserResult);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public ReqRes signIn(ReqRes signinRequest){
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
            var user = ourUserRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenReqiest){
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenReqiest.getToken());
        OurUsers users = ourUserRepo.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenReqiest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
    
    public void sendOtp(String email) throws MessagingException {
        // Tạo OTP
        String otp = String.valueOf(new Random().nextInt(999999));
        System.out.println("Generated OTP: " + otp);

        Context context = new Context();
        context.setVariable("name", "User"); // Có thể lấy tên từ database
        context.setVariable("otp", otp);

        // Tạo nội dung email từ template
        String process = templateEngine.process("otp-email.html", context);
        System.out.println("Email content: " + process);

        // Tạo và gửi email
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(email);
        helper.setSubject("Password Reset OTP");
        helper.setText(process, true);

        try {
            mailSender.send(message);
        } catch (MailException ex) {
            // Xử lý lỗi tại đây
            ex.printStackTrace();
        }
    }
}
