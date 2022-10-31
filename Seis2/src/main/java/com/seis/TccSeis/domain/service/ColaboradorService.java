/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.ColaboradorModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface ColaboradorService {
    
    List<ColaboradorModel> list();

    Boolean add(ColaboradorModel colaborador);

    Boolean edit(String id,ColaboradorModel colaborador);

    Boolean delete(String id);
    
}
