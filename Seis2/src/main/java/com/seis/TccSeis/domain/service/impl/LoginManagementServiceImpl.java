///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.seis.TccSeis.domain.service.impl;
//
//import com.google.cloud.firestore.CollectionReference;
//import com.google.firebase.auth.FirebaseAuth;
//import com.seis.TccSeis.api.firebase.FirebaseInitializer;
//import com.seis.TccSeis.domain.model.LoginModel;
//import com.seis.TccSeis.domain.service.LoginService;
//import java.util.List;
//import lombok.NonNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.config.Task;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author kauar
// */
//@Service
//public class LoginManagementServiceImpl implements LoginService {
//    
//    @Autowired
//    private FirebaseInitializer firebase;
//    
//    private FirebaseAuth mAuth;
//    
//   
//    private CollectionReference getCollection() {
//        return firebase.getFirestore().collection("Cliente");
//    }
//
//    @Override
//    public List<LoginModel> list() {
//        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Boolean register(LoginModel login) {
//        mAuth.createUserWithEmailAndPassword(login)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(MainActivity.this, "Deu certo",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(MainActivity.this, "Nao deu certo",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//               
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Boolean edit(String email, LoginModel login) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Boolean delete(String email) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Boolean login(LoginModel login) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Boolean register(LoginModel login) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//}
