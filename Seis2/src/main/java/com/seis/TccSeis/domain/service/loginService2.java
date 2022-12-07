/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.loginModel2;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface loginService2 {
    
    List<loginModel2> list();

    Boolean add(loginModel2 login);

    Boolean edit(String id,loginModel2 login);

    Boolean delete(String id); 
}
