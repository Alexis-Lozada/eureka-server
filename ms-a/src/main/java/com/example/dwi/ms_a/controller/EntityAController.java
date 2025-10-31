package com.example.dwi.ms_a.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dwi.ms_a.dto.EntityADTO;
import com.example.dwi.ms_a.entity.EntityA;
import com.example.dwi.ms_a.service.EntityAService;


@RestController
@RequestMapping("/api/entity-a")
@CrossOrigin(origins = "*")
public class EntityAController {

    @Autowired
    private EntityAService entityAService;

    @PostMapping("/by-ids")
    public List<EntityADTO> getByIds(@RequestBody List<Integer> ids) {
        // Obtener las entidades por IDs
        List<EntityA> entities = entityAService.findByIds(ids);

        // Convertir a DTOs
        return entities.stream()
                .map(e -> {
                    EntityADTO dto = new EntityADTO();
                    dto.setId(e.getId());
                    dto.setNombreA(e.getNombreA());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Obtener todas las EntityA
    @GetMapping
    public ResponseEntity<List<EntityA>> findAll() {
        List<EntityA> list = entityAService.findAll();
        return ResponseEntity.ok(list);
    }

    // Obtener una EntityA por ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityA> findById(@PathVariable int id) {
        EntityA entity = entityAService.findById(id);
        return (entity != null) ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    // Crear nueva EntityA
    @PostMapping
    public ResponseEntity<EntityA> create(@RequestBody EntityADTO dto) {
        EntityA created = entityAService.create(dto);
        return ResponseEntity.ok(created);
    }

    // Actualizar una EntityA existente
    @PutMapping("/{id}")
    public ResponseEntity<EntityA> update(@PathVariable int id, @RequestBody EntityADTO dto) {
        dto.setId(id);
        EntityA updated = entityAService.update(dto);
        return ResponseEntity.ok(updated);
    }

    // Eliminar una EntityA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = entityAService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
