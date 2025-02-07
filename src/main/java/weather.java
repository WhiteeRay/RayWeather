package weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weather {
    private String condition;
    private double temperature;
    private double humidity;
    private double windSpeed;
}