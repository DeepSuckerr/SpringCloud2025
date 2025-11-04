package com.wsj.apis.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Claude
 * @date 2025/11/04
 */
@FeignClient(value = "cloud-payment-service")
public interface CircuibreakerAPI {

    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

}
