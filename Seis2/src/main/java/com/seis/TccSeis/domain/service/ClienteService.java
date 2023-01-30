/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.ClienteModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-a
 */
@Service
public interface ClienteService {
    
    List<ClienteModel> list();
    
    //List<ClienteModel> listId(String cep); 

    Boolean add(ClienteModel cliente);

    Boolean edit(String id,ClienteModel cliente);

    Boolean delete(String id); 
}
