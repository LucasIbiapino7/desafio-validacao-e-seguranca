package com.devsuperior.demo.controllers;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAllSorted(){
        List<CityDTO> result = service.findAllSorted();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto){
        dto = service.insert(dto);
        return ResponseEntity.ok(dto);
    }

}
