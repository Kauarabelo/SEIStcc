/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author kauar
 */
@Data
public class loginModel2 {
    
    @NotBlank
    @Size(max = 300)
    private String email;
    
    @NotBlank
    @Size(max = 300)
    private String password;

    public loginModel2() {
        //Defalt
    }

    public loginModel2(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
  

}
