package com.example.dwi.ms_a.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dwi.ms_a.entity.EntityA;
import com.example.dwi.ms_a.repository.EntityARepository;

@Service
public class EntityAService {

    @Autowired
    private EntityARepository repository;

    public List<EntityA> findByIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }
}
