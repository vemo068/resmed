package com.example.resmed.controller;


import com.example.resmed.dto.HourWithRdvs;
import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Speciality;
import com.example.resmed.repository.HourLabelRepository;
import com.example.resmed.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HourLabelController {

    @Autowired
    private HourLabelRepository hourLabelRepository;
    @Autowired
    private RdvService rdvService;

    @GetMapping("/hourlabels")
    public ResponseEntity<List<HourLabel>> getAllHourLabels() {
        return ResponseEntity.ok(hourLabelRepository.findAll());
    }

    @RequestMapping(value="avhours", method = RequestMethod.GET)
    public @ResponseBody
     List<HourLabel> getAvHourLabels(@RequestParam("dr_id") Long doctorId,@RequestParam("date") String date) {
        List<HourLabel> hh= rdvService.av_hourLabels(doctorId,date);
        return hh;
    }
    @RequestMapping(value="listrdvs", method = RequestMethod.GET)
    public @ResponseBody
    List<HourWithRdvs> getListRdvs(@RequestParam("dr_id") Long doctorId, @RequestParam("date") String date) {
        List<HourWithRdvs> hh= rdvService.listRdvs(doctorId,date);
        return hh;
    }
}

