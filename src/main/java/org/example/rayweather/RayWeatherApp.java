package org.example.rayweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RayWeatherApp {
    public static void main(String[] args) {
        SpringApplication.run(RayWeatherApp.class, args);
    }

}
