package com.example.resmed.controller;


import com.example.resmed.entity.Rdv;
import com.example.resmed.repository.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SocController {
    @Autowired
    private RdvRepository rdvRepository;
    @MessageMapping("/hello")
        public List<Rdv> rdvList(){
        return rdvRepository.findAll();
        }
}
