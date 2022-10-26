/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service;

import com.seis.TccSeis.domain.model.VolumeModel;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface VolumeService {
    
    List<VolumeModel> list();

    Boolean add(VolumeModel volume);

    Boolean edit(String id,VolumeModel volume);

    Boolean delete(String id);
    
}
