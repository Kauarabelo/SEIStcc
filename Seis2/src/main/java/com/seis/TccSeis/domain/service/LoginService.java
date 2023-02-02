/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.LoginModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface LoginService {
    
    List<LoginModel> list();
    
    LoginModel getLogin(LoginModel dadosLogin);

    Boolean add(LoginModel login);

    Boolean edit(String id,LoginModel login);

    Boolean delete(String id); 
}
