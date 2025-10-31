package com.idgs12.ms.ms1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idgs12.ms.ms1.entity.EntityA;
import com.idgs12.ms.ms1.repository.EntityARepository;

@Service
public class EntityAService {

    @Autowired
    private EntityARepository repository;

    public List<EntityA> findByIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }
}
