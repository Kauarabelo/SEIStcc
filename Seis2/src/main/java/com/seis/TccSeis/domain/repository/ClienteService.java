/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.repository;

import com.seis.TccSeis.domain.model.ClienteModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface ClienteService {
    
    List<ClienteModel> list();

    Boolean add(ClienteModel cliente);

    Boolean edit(String id,ClienteModel cliente);

    Boolean delete(String id); 
}
