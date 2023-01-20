/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.connect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author devsys-a
 */
@Configuration
@Component
@Data
public class ApplicationConfig {

    @Value("${fireBase.dbBaseUrl}")
    private String dbBaseUrl;
    @Value("${fireBase.collection}")
    private String collectionName;
    @Value("${fireBase.authFileLocation}")
    private String authFileLocation;

}
