package com.example.dwi.ms_b.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.dwi.ms_b.dto.EntityBDTO;
import com.example.dwi.ms_b.entity.EntityB;
import com.example.dwi.ms_b.service.EntityBService;

@RestController
@RequestMapping("/api/entity-b")
public class EntityBController {

    private final EntityBService service;

    public EntityBController(EntityBService service) {
        this.service = service;
    }

    // GET - Listar todos
    @GetMapping
    public List<EntityB> getAll() {
        return service.findAll();
    }

    // GET - Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<EntityB> getById(@PathVariable int id) {
        Optional<EntityB> entity = service.findById(id);
        return entity.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // POST - Crear
    @PostMapping
    public ResponseEntity<EntityB> create(@RequestBody EntityBDTO dto) {
        EntityB created = service.create(dto);
        return ResponseEntity.ok(created);
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<EntityB> update(@PathVariable int id, @RequestBody EntityBDTO dto) {
        Optional<EntityB> updated = service.update(id, dto);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}
