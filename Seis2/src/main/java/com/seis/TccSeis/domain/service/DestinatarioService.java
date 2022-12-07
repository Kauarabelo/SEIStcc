/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.DestinatarioModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface DestinatarioService {
    
    List<DestinatarioModel> list();

    Boolean add(DestinatarioModel destinatario);

    Boolean edit(String id,DestinatarioModel destinatario);

    Boolean delete(String id);
    
}
