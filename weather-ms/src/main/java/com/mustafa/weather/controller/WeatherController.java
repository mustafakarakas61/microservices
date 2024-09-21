package com.mustafa.weather.controller;

import com.mustafa.weather.model.WeatherResponse;
import com.mustafa.weather.service.WeatherService;
import com.mustafa.weather.utils.Utility;
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
    public WeatherResponse getWeatherInfo(@RequestParam String city) throws Exception {
        city = Utility.fixCityName(city);

        if (city == null || city.isEmpty()) {
            throw new Exception("Please, give a city name");
        }

        return weatherService.getWeather(city);
    }

}
