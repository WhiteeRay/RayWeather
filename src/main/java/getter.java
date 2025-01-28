// File: City.java
public class City {
    // Declare fields as final if they should be immutable
    private final int id;
    private final String place_id;
    private final String city_name;

    // Constructor
    public City(int id, String place_id, String city_name) {
        this.id = id;
        this.place_id = place_id;
        this.city_name = city_name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for place_id
    public String getPlace_id() {
        return place_id;
    }

    // Getter for city_name
    public String getCity_name() {
        return city_name;
    }

    // Optional toString method to print object information easily
    @Override
    public String toString() {
        return "City [id=" + id + ", place_id=" + place_id + ", city_name=" + city_name + "]";
    }
}

// File: Main.java (a separate file)
public class Main {
    public static void main(String[] args) {
        // Create a new City object
        City city = new City(1, "P123", "New York");

        // Use getters to retrieve field values
        System.out.println("City ID: " + city.getId());
        System.out.println("Place ID: " + city.getPlace_id());
        System.out.println("City Name: " + city.getCity_name());
    }
}
