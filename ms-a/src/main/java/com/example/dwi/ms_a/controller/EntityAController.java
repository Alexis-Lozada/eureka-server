package com.example.dwi.ms_a.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
}
