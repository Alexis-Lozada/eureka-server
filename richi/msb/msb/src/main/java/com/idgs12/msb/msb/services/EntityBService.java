package com.idgs12.msb.msb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idgs12.msb.msb.dto.EntityBDtoList;
import com.idgs12.msb.msb.dto.DtoEntityA;
import com.idgs12.msb.msb.entity.EntityB;
import com.idgs12.msb.msb.entity.EntityBEntityA;
import com.idgs12.msb.msb.repository.RepositoryEntityB;
import com.idgs12.msb.msb.FeignClient.ClientFeignMSA;

@Service
public class EntityBService {

    @Autowired
    private RepositoryEntityB repository;

    @Autowired
    private ClientFeignMSA clientFeignMSA;

    // Read all
    @Transactional(readOnly = true)
    public List<EntityBDtoList> findAll() {
        List<EntityB> datos = repository.findAll();

        List<Integer> ids = datos.stream()
                .flatMap(relacion -> relacion.getEntityBEntityAs().stream())
                .map(EntityBEntityA::getIdEntityBId)
                .distinct()
                .collect(Collectors.toList());

        Map<Integer, String> entidadAIdNombreAMap = new HashMap<>();
        List<DtoEntityA> entityADtos = clientFeignMSA.obtenerDTOsDelMSA(ids);
        if (entityADtos != null) {
            for (DtoEntityA dto : entityADtos) {
                if (dto != null) {
                    entidadAIdNombreAMap.put(dto.getId(), dto.getNombreA());
                }
            }
        }

        List<EntityBDtoList> datosList = datos
                .stream()
                .map(e -> {
                    EntityBDtoList dto = new EntityBDtoList();
                    dto.setId(e.getId());
                    dto.setNombreB(e.getNameB());

                    if (e.getEntityBEntityAs() != null && !e.getEntityBEntityAs().isEmpty()) {
                        EntityBEntityA relacion = e.getEntityBEntityAs().get(0);
                        if (relacion != null && relacion.getIdEntityBId() != 0) {
                            String nombreA = entidadAIdNombreAMap.get(relacion.getIdEntityBId());
                            dto.setNombreA(nombreA != null ? nombreA : "Sin dato de MSA");
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList());

        return datosList;
    }
}
