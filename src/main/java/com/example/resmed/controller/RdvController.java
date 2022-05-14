package com.example.resmed.controller;

import com.example.resmed.dto.RendV;
import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Rdv;
import com.example.resmed.repository.RdvRepository;
import com.example.resmed.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping
public class RdvController {
    @Autowired
    private RdvRepository rdvRepository;
    @Autowired
    private RdvService rdvService;


    @GetMapping("/rdvs")
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }


    @PostMapping("/sendrdv")
    public ResponseEntity<Rdv> postBody(@RequestBody RendV rendV) throws URISyntaxException {

             Rdv rdv1=rdvService.saveRdv(rendV);
        if (rdv1 == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(rdv1.getAppointId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(rdv1);
        }
    }

}
