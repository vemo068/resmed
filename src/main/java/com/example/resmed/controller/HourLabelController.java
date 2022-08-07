package com.example.resmed.controller;


import com.example.resmed.dto.HourWithRdvs;
import com.example.resmed.entity.HourLabel;
import com.example.resmed.entity.Speciality;
import com.example.resmed.entity.User;
import com.example.resmed.repository.HourLabelRepository;
import com.example.resmed.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
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
        List<HourWithRdvs> listOfAppointements= rdvService.listRdvs(doctorId,date);
        return listOfAppointements;
    }

    @PostMapping("/addhour")
    public ResponseEntity<HourLabel> postBody(@RequestBody HourLabel hourLabel) throws URISyntaxException {

        HourLabel neUser=HourLabel.builder()
                .label(hourLabel.getLabel())
                .build();
        HourLabel newUser=hourLabelRepository.save(neUser);
        if (newUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newUser.getLabelId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(newUser);
        }
    }
}

