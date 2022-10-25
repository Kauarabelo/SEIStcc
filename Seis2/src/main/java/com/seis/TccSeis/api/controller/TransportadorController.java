/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.api.controller;

import org.springframework.web.bind.annotation.*;
import com.seis.TccSeis.domain.model.TransportadorModel;
import com.seis.TccSeis.domain.service.TransportadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author devsys-a
 */

@RestController
@RequestMapping(value = "/cliente")
public class TransportadorController {
    
    @Autowired
    private TransportadorService service;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody TransportadorModel transportador){
        return new ResponseEntity(service.add(transportador), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody TransportadorModel transportador){
        return new ResponseEntity(service.edit(id,transportador), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    
}
