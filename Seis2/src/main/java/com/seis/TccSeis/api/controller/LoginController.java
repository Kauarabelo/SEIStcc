///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.seis.TccSeis.api.controller;
//
//import com.seis.TccSeis.domain.model.LoginModel;
//import com.seis.TccSeis.domain.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author kauar
// */
//@RestController
//@RequestMapping(value = "/auth")
//public class LoginController {
//    
//    @Autowired
//    private LoginService service;
//    
//    @GetMapping(value = "/login")
//    public ResponseEntity login(@RequestBody LoginModel login){
//        return new ResponseEntity(service.login(login), HttpStatus.OK);       
//    
//    }
//    
//    @GetMapping(value = "/register")
//    public ResponseEntity register(@RequestBody LoginModel register){
//        return new ResponseEntity(service.register(register), HttpStatus.OK);
//    
//    }
// 
//}
