/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.repository;

import com.seis.TccSeis.domain.model.PostDTO;
import java.util.List;

/**
 *
 * @author devsys-a
 */
public interface PostManagementService {
    
    List<PostDTO> list();

    Boolean add(PostDTO post);

    Boolean edit(String id,PostDTO post);

    Boolean delete(String id);
    
}
