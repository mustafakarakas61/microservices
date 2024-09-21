package com.mustafa.weather.controller;

import com.mustafa.weather.model.WeatherResponse;
import com.mustafa.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public WeatherResponse getWeatherInfo(@RequestParam String city) {
            return weatherService.getWeather(city);
    }

}
