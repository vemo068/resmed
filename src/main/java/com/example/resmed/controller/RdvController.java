package com.example.resmed.controller;

import com.example.resmed.dto.RendV;
import com.example.resmed.entity.Doctor;
import com.example.resmed.entity.Rdv;
import com.example.resmed.entity.Speciality;
import com.example.resmed.entity.User;
import com.example.resmed.repository.RdvRepository;
import com.example.resmed.repository.UserRepository;
import com.example.resmed.services.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class RdvController {
    @Autowired
    private RdvRepository rdvRepository;
    @Autowired
    private RdvService rdvService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/rdvs")
    public List<Rdv> getAllRdvs() {
        return rdvRepository.findAll();
    }

    @RequestMapping(value="myappointmenst", method = RequestMethod.GET)
    public @ResponseBody
        List<Rdv> getSpecialityDoctors(@RequestParam("id") Long userId){

        User user=userRepository.findByUserId(userId);
        List<Rdv> userAppoitements=rdvRepository.findByUser(user);

        return userAppoitements;
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
