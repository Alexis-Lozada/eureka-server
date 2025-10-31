package com.example.dwi.ms_b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dwi.ms_b.dto.EntityBDtoList;
import com.example.dwi.ms_b.service.EntityBService;

@RestController
@RequestMapping("/api/entityB")
@CrossOrigin(origins = "*")
public class EntityBController {

    @Autowired
    private EntityBService entityBService;

    // Obtiene todas las EntityB con información relacionada de EntityA desde MSA
    @GetMapping("/all")
    public ResponseEntity<List<EntityBDtoList>> findAll() {
        List<EntityBDtoList> entities = entityBService.findAll();
        return ResponseEntity.ok(entities);
    }
}
