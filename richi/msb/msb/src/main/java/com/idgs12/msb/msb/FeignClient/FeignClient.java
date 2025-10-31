package com.idgs12.msb.msb.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms1")
public interface FeignClient {
}
