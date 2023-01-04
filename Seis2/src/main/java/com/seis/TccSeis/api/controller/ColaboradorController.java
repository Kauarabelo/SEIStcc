/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.api.controller;

import org.springframework.web.bind.annotation.*;
import com.seis.TccSeis.domain.model.ColaboradorModel;
import com.seis.TccSeis.domain.repository.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author devsys-a
 */

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService service;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable(value = "name") String name){
        return  "Hello, "+name;
    }

    @GetMapping(value = "/list")
    public ResponseEntity list(){
        return new ResponseEntity(service.list(), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody ColaboradorModel colaborador){
        return new ResponseEntity(service.add(colaborador), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") String id_Colaborador, @RequestBody ColaboradorModel colaborador){
        return new ResponseEntity(service.edit(id_Colaborador,colaborador), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") String id){
        return  new ResponseEntity(service.delete(id), HttpStatus.OK);
    }
    
}
