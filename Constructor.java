public class City {
    // Instance variables
    private int id;
    private String place_id;
    private String city_name;

    // Constructor
    public City(int id, String place_id, String city_name) {
        this.id = id;
        this.place_id = place_id;
        this.city_name = city_name;
    }

    // Getters and setters (optional, if needed)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceId() {
        return place_id;
    }

    public void setPlaceId(String place_id) {
        this.place_id = place_id;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String city_name) {
        this.city_name = city_name;
    }

    // Optional toString method to print object information easily
    @Override
    public String toString() {
        return "City [id=" + id + ", place_id=" + place_id + ", city_name=" + city_name + "]";
    }
}
