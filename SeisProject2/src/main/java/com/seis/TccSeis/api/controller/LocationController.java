package com.seis.TccSeis.api.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.web.bind.annotation.*;

/**
 *
 * @author devsys-a
 */

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {
    
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping( value = "/getEmployee", produces = "application/json")
    public ResponseEntity<Object> getEmployee(@RequestParam("empId") String empId) throws ExecutionException, InterruptedException {
        TripTracking tripTracking = locationService.getLiveTrace(empId);
        if(!StringUtils.isEmpty(employee)){
            return ResponseHandler.response(employee,"Current Employee",true,HttpStatus.OK);
        }
        return ResponseHandler.response(employee,"Invalid employee Id",false,HttpStatus.NOT_FOUND);
    }
    
    @PostMapping(value = "/saveEmployee", produces = "application/json")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee)
            throws ExecutionException, InterruptedException {
        Employee employee = locationService.saveEmployee(employee);
        return ResponseHandler.response(employee, "Employee stored", true, HttpStatus.OK);
    }
    
}
