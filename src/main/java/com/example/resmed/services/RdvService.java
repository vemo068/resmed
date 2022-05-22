package com.example.resmed.services;

import com.example.resmed.dto.HourWithRdvs;
import com.example.resmed.dto.RendV;
import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.User;
import com.example.resmed.repository.DoctorRepository;
import com.example.resmed.repository.HourLabelRepository;
import com.example.resmed.repository.RdvRepository;
import com.example.resmed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RdvService {

        @Autowired
        private RdvRepository rdvRepository;
        @Autowired
        private DoctorRepository doctorRepository;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private HourLabelRepository hourLabelRepository;

        public Rdv saveRdv(RendV rendV){

                HourLabel hour=hourLabelRepository.findByLabelId(rendV.getLabel_id());
                Doctor dr=doctorRepository.findByDoctorId(rendV.getDoctor_id());
                User user=userRepository.findByUserId(rendV.getUser_id());



                Rdv newRdv= rdvRepository.save(new Rdv(rendV.getDate(),user,dr,hour ));
                return newRdv;
        }


        public List<HourLabel> av_hourLabels(Long doctorId, String date){
                Doctor dr=doctorRepository.findByDoctorId(doctorId);
                List<HourLabel> av_hr = new ArrayList<>();
                List<HourLabel> allHr=hourLabelRepository.findAll();

                for ( HourLabel hr:
                    allHr ) {
                        List<Rdv> hrRdvs=rdvRepository.findByHourLabelAndDoctorAndDate(hr,dr,date);
                        if(hrRdvs.size()<dr.getHourLimit()){
                                av_hr.add(hr);
                        }
                }
                return av_hr;
        }




        public List<HourWithRdvs> listRdvs(Long doctorId, String date){
                Doctor dr=doctorRepository.findByDoctorId(doctorId);
                List<HourWithRdvs> hourWithRdvs = new ArrayList<>();
                List<HourLabel> allHr=hourLabelRepository.findAll();

                for ( HourLabel hr:
                        allHr ) {
                        List<Rdv> hrRdvs=rdvRepository.findByHourLabelAndDoctorAndDate(hr,dr,date);


                                hourWithRdvs.add(new HourWithRdvs(hr,hrRdvs));

                }
                return hourWithRdvs;
        }

}
