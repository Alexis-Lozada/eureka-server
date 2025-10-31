package com.idgs12.ms.ms1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.idgs12.ms.ms1.dto.DtoEntityA;
import com.idgs12.ms.ms1.services.EntityAService;
import com.idgs12.ms.ms1.entity.EntityA;

@RestController
@RequestMapping("/api/entity-a")
@CrossOrigin(origins = "*")
public class EntityAController {

    @Autowired
    private EntityAService entityAService;

    @PostMapping("/by-ids")
    public List<DtoEntityA> getByIds(@RequestBody List<Integer> ids) {
        // Obtener las entidades por IDs
        List<EntityA> entities = entityAService.findByIds(ids);

        // Convertir a DTOs
        return entities.stream()
                .map(e -> {
                    DtoEntityA dto = new DtoEntityA();
                    dto.setId(e.getId());
                    dto.setNombreA(e.getNombreA());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
