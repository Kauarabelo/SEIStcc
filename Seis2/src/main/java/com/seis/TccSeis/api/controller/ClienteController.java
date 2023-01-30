/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.api.controller;
;
import com.seis.TccSeis.domain.model.ClienteModel;
import org.springframework.web.bind.annotation.*;
import com.seis.TccSeis.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author devsys-a
 */

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/greet/{name}")
    @CrossOrigin("http://localhost:4200/")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/add")
        @CrossOrigin("http://localhost:4200/")
    public ResponseEntity add(@RequestBody ClienteModel cliente){
        return new ResponseEntity(service.add(cliente), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id, @RequestBody ClienteModel cliente){
        return new ResponseEntity(service.edit(id,cliente), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    
}
