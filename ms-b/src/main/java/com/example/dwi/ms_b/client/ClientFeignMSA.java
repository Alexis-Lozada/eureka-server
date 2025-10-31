package com.example.dwi.ms_b.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dwi.ms_b.dto.EntityADTO;

@FeignClient(name="ms-a")
public interface ClientFeignMSA {

    @PostMapping("/api/entity-a/by-ids")
    public List<EntityADTO> obtenerDTOsDelMSA(List<Integer> ids);

}
