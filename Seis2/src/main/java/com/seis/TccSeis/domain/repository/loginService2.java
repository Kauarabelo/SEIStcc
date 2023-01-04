/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.repository;

import com.seis.TccSeis.domain.model.User;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface loginService2 {
    
    List<User> list();

    Boolean add(User login);

    Boolean edit(String id,User login);

    Boolean delete(String id); 
}
