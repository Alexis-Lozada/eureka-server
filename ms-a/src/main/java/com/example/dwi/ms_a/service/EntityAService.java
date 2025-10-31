package com.example.dwi.ms_a.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dwi.ms_a.dto.EntityADTO;
import com.example.dwi.ms_a.entity.EntityA;
import com.example.dwi.ms_a.repository.EntityARepository;

@Service
public class EntityAService {

    @Autowired
    private EntityARepository repository;

    public List<EntityA> findByIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }

    public List<EntityA> findAll() {
        return repository.findAll();
    }

    public EntityA findById(int id) {
        Optional<EntityA> optional = repository.findById(id);
        return optional.orElse(null);
    }

    public EntityA create(EntityADTO dto) {
        EntityA entity = toEntity(dto);
        return repository.save(entity);
    }

    public EntityA update(EntityADTO dto) {
        EntityA entity = toEntity(dto);
        return repository.save(entity);
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private EntityA toEntity(EntityADTO dto) {
        EntityA entity = new EntityA();
        entity.setId(dto.getId());
        entity.setNombreA(dto.getNombreA());
        return entity;
    }
}
