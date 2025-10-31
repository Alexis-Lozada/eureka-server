package com.idgs12.msb.msb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.idgs12.msb.msb.dto.EntityBDtoList;
import com.idgs12.msb.msb.services.EntityBService;

@RestController
@RequestMapping("/api/entityB")
@CrossOrigin(origins = "*")
public class EntityBController {

    @Autowired
    private EntityBService entityBService;

    /**
     * Obtiene todas las EntityB con información relacionada de EntityA desde MSA
     */
    @GetMapping("/all")
    public ResponseEntity<List<EntityBDtoList>> findAll() {
        List<EntityBDtoList> entities = entityBService.findAll();
        return ResponseEntity.ok(entities);
    }
}
