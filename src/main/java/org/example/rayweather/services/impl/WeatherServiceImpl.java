package org.example.rayweather.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.rayweather.entities.Weather;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Cacheable(value = "weatherCache", key = "#place_id")
    public List<Weather> getWeathers(String place_id) {
        String API_URL = "https://www.meteosource.com/api/v1/free/point?key=wj41qlc7ukds7tj5n2iisohhfxu843nhepoxmpz8&place_id=" + place_id + "&sections=daily";
        List<Weather> weathers = new ArrayList<>();
        Thread.sleep(2000);

        String jsonResponse = restTemplate.getForObject(API_URL, String.class);

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode dailyNode = rootNode.path("daily").path("data");

            if (dailyNode.isArray()) {
                for (JsonNode dayNode : dailyNode) {
                    String day = dayNode.path("day").asText();
                    String summary = dayNode.path("summary").asText();
                    Weather weather = new Weather(day, summary);
                    weathers.add(weather);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weathers;
    }

    @CachePut(value = "weatherCache", key = "#place_id")
    public List<Weather> updateWeathers(String place_id) {
        String API_URL = "https://www.meteosource.com/api/v1/free/point?key=wj41qlc7ukds7tj5n2iisohhfxu843nhepoxmpz8&place_id=" + place_id + "&sections=daily";
        List<Weather> weathers = new ArrayList<>();

        String jsonResponse = restTemplate.getForObject(API_URL, String.class);

        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode dailyNode = rootNode.path("daily").path("data");

            if (dailyNode.isArray()) {
                for (JsonNode dayNode : dailyNode) {
                    String day = dayNode.path("day").asText();
                    String summary = dayNode.path("summary").asText();
                    Weather weather = new Weather(day, summary);
                    weathers.add(weather);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weathers;
    }

    @CacheEvict(value = "weatherCache", allEntries = true)
    public void evictAllWeatherCache() {

    }
}
