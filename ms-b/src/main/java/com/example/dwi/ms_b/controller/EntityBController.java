package com.example.dwi.ms_b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dwi.ms_b.dto.EntityBDTO;
import com.example.dwi.ms_b.dto.EntityBDtoList;
import com.example.dwi.ms_b.entity.EntityB;
import com.example.dwi.ms_b.service.EntityBService;

@RestController
@RequestMapping("/api/entityB")
@CrossOrigin(origins = "*")
public class EntityBController {

    @Autowired
    private EntityBService entityBService;

    // Obtener todas las EntityB con información relacionada de EntityA desde MSA
    @GetMapping("/all")
    public ResponseEntity<List<EntityBDtoList>> findAll() {
        List<EntityBDtoList> entities = entityBService.findAll();
        return ResponseEntity.ok(entities);
    }

    // Obtener todas las EntityB
    @GetMapping
    public ResponseEntity<List<EntityB>> findAllEntityB() {
        List<EntityB> entities = entityBService.findAllEntityB();
        return ResponseEntity.ok(entities);
    }

    // Obtener una EntityB por ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityB> findById(@PathVariable int id) {
        EntityB entity = entityBService.findById(id);
        return (entity != null) ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    //Crear una nueva EntityB
    @PostMapping
    public ResponseEntity<EntityB> create(@RequestBody EntityBDTO dto) {
        EntityB created = entityBService.create(dto);
        return ResponseEntity.ok(created);
    }

    // Actualizar una EntityB existente
    @PutMapping("/{id}")
    public ResponseEntity<EntityB> update(@PathVariable int id, @RequestBody EntityBDTO dto) {
        dto.setId(id);
        EntityB updated = entityBService.update(dto);
        return ResponseEntity.ok(updated);
    }

    // Eliminar una EntityB por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = entityBService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
