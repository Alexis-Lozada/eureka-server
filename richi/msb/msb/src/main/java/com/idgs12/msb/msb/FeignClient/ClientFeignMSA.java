package com.idgs12.msb.msb.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.idgs12.msb.msb.dto.DtoEntityA;

@FeignClient(name = "MS1")
public interface ClientFeignMSA {

    @PostMapping("/api/entity-a/by-ids")
    public List<DtoEntityA> obtenerDTOsDelMSA(List<Integer> ids);

}