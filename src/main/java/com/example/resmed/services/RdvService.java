package com.example.resmed.services;

import com.example.resmed.dto.RendV;
import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.User;
import com.example.resmed.repository.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RdvService {

        @Autowired
        private RdvRepository rdvRepository;

        public Rdv saveRdv(RendV rendV){


                Rdv newRdv= rdvRepository.save(new Rdv(new User(rendV.getUser_id()),new Doctor(rendV.getDoctor_id()),new HourLabel(rendV.getLabel_id())));
                return newRdv;
        }

}
