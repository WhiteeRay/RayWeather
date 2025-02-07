public class bodypart {public class Weather {
    private String day;
    private String weather;


    public Weather(String day, String weather) {
        this.day = day;
        this.weather = weather;
    }


    public String getDay() {
        return day;
    }


    public void setDay(String day) {
        this.day = day;
    }


    public String getWeather() {
        return weather;
    }


    public void setWeather(String weather) {
        this.weather = weather;
    }


    public void displayWeather() {
        System.out.println("Day: " + day + ", Weather: " + weather);
    }
}

}
