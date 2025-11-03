package com.wsj.controller;


import com.alibaba.fastjson2.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Tag(name="获取天气预报信息")
public class WeatherController {


    @Value("${weather.key}")
    String weatherKey;

    @Autowired
    @Qualifier("externalRestTemplate")
    RestTemplate restTemplate;


    @GetMapping("/getWeatherInfo")
    @Operation(summary = "获取天气信息")
    public JSONObject getWeatherInfo(@RequestParam("city") String city) {
        JSONObject result = restTemplate.getForObject("http://apis.juhe.cn/simpleWeather/query?key=" + weatherKey + "&city=" + city,
                JSONObject.class);

        System.out.println("result"+result);
        return result;
    }


}
