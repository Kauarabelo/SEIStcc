/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.api.controller;

import org.springframework.web.bind.annotation.*;
import com.seis.TccSeis.domain.model.DestinatarioModel;
import com.seis.TccSeis.domain.repository.DestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author devsys-a
 */

@RestController
@RequestMapping(value = "/destinatario")
public class DestinatarioController {
    
    @Autowired
    private DestinatarioService service;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody DestinatarioModel destinatario){
        return new ResponseEntity(service.add(destinatario), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id_Destinatario, @RequestBody DestinatarioModel destinatario){
        return new ResponseEntity(service.edit(id_Destinatario,destinatario), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    
}
