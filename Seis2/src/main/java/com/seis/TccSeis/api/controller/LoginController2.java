/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.api.controller;

import com.seis.TccSeis.domain.model.User;
import com.seis.TccSeis.domain.repository.loginService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kauar
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController2 {
    
    @Autowired
    private loginService2 service;

    @GetMapping(value = "/greet/{name}")
    @CrossOrigin("http://localhost:19006")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/add")
    @CrossOrigin("http://localhost:19006")
    public ResponseEntity add(@RequestBody User login){
        return new ResponseEntity(service.add(login), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody User login){
        return new ResponseEntity(service.edit(id,login), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    
}
