package com.idgs12.msb.msb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idgs12.msb.msb.dto.DtoEntityB;
import com.idgs12.msb.msb.entity.EntityB;
import com.idgs12.msb.msb.repository.RepositoryEntityB;

@Service
@Transactional
public class ServicesEntityB {

    @Autowired
    private RepositoryEntityB repositoryEntityB;

    public List<EntityB> findAll() {
        return repositoryEntityB.findAll();
    }

    public EntityB findById(int id) {
        Optional<EntityB> optional = repositoryEntityB.findById(id);
        return optional.orElse(null);
    }

    public EntityB create(DtoEntityB dtoEntityB) {
        EntityB entityB = toEntity(dtoEntityB);
        return repositoryEntityB.save(entityB);
    }

    public EntityB update(DtoEntityB dtoEntityB) {
        EntityB entityB = toEntity(dtoEntityB);
        return repositoryEntityB.save(entityB);
    }

    public boolean delete(int id) {
        if (repositoryEntityB.existsById(id)) {
            repositoryEntityB.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private EntityB toEntity(DtoEntityB dtoEntityB) {
        EntityB entityB = new EntityB();
        entityB.setId(dtoEntityB.getId());
        entityB.setNameB(dtoEntityB.getNameB());
        return entityB;
    }
}
