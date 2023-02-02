/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.api.controller;

import com.seis.TccSeis.domain.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.seis.TccSeis.domain.service.LoginService;

/**
 *
 * @author kauar
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService service;

    
    @GetMapping(value = "/login")
    public ResponseEntity list() {
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    @PostMapping(value = "/login")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity add(@RequestBody LoginModel dadosLogin) {

        // Verificar retorno da service.getLogin
        try {
            if (service.getLogin(dadosLogin) != null) {

                return new ResponseEntity(service.getLogin(dadosLogin), HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Ocorreu algum erro! ", HttpStatus.UNAUTHORIZED);
        }   
    }
    
    @PostMapping(value = "/cadastrar")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity verifica(@RequestBody LoginModel dadosLogin) {

        // Verificar retorno da service.getLogin
        try {
            if (service.getLogin(dadosLogin) != null) {

                return new ResponseEntity(service.getLogin(dadosLogin), HttpStatus.CREATED);
            }
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Ocorreu algum erro! ", HttpStatus.UNAUTHORIZED);
        }

    }
}
