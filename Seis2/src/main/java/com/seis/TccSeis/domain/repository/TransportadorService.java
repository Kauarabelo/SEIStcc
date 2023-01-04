/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.repository;

import com.seis.TccSeis.domain.model.TransportadorModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface TransportadorService {
    
    List<TransportadorModel> list();

    Boolean add(TransportadorModel transportador);

    Boolean edit(String id,TransportadorModel transportador);

    Boolean delete(String id);
    
}
