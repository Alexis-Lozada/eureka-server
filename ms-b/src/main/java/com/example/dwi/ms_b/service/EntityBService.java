package com.example.dwi.ms_b.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.dwi.ms_b.dto.EntityBDTO;
import com.example.dwi.ms_b.entity.EntityB;
import com.example.dwi.ms_b.repository.EntityBRepository;

@Service
public class EntityBService {

    private final EntityBRepository repository;

    public EntityBService(EntityBRepository repository) {
        this.repository = repository;
    }

    // Obtener todos
    public List<EntityB> findAll() {
        return repository.findAll();
    }

    // Obtener por ID
    public Optional<EntityB> findById(int id) {
        return repository.findById(id);
    }

    // Crear
    public EntityB create(EntityBDTO dto) {
        EntityB entity = new EntityB();
        entity.setName(dto.getNombreA());
        return repository.save(entity);
    }

    // Actualizar
    public Optional<EntityB> update(int id, EntityBDTO dto) {
        return repository.findById(id).map(entity -> {
            entity.setName(dto.getNombreA());
            return repository.save(entity);
        });
    }

    // Eliminar
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
