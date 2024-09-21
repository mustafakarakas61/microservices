package com.mustafa.weather.service;

import com.mustafa.weather.config.AppProperties;
import com.mustafa.weather.model.WeatherResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    private final AppProperties appProperties;

    public WeatherService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }


    @Cacheable("weather")
    public WeatherResponse getWeather(String city) {
        RestTemplate  restTemplate = new RestTemplate();

        String uri = UriComponentsBuilder.fromHttpUrl(appProperties.getApiUrl())
                .queryParam("q", city)
                .queryParam("appid", appProperties.getApiKey())
                .queryParam("units", "metric")
                .toUriString();

        return restTemplate.getForObject(uri, WeatherResponse.class);
    }
}
