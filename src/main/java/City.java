public class City {
    // Fields
    private int id;
    private int placeId;  // Changed to camelCase for Java convention
    private String cityName;  // Changed to camelCase for Java convention

    // Constructor
    public City(int id, int placeId, String cityName) {
        this.id = id;
        this.placeId = placeId;
        this.cityName = cityName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    // ToString method for printing
    @Override
    public String toString() {
        return "City [id=" + id + ", placeId=" + placeId + ", cityName=" + cityName + "]";
    }

    // Main method for testing
    public static void main(String[] args) {
        City city = new City(1, 101, "New York");

        // Using getter methods
        System.out.println("City ID: " + city.getId());
        System.out.println("Place ID: " + city.getPlaceId());
        System.out.println("City Name: " + city.getCityName());

        // Use setter methods to update values
        city.setId(2); // Updating ID
        city.setPlaceId(202); // Updating Place ID
        city.setCityName("Los Angeles"); // Updating City Name

        // Printing updated city information
        System.out.println("\nUpdated City Information:");
        System.out.println("City ID: " + city.getId());
        System.out.println("Place ID: " + city.getPlaceId());
        System.out.println("City Name: " + city.getCityName());

        // Or simply use toString method
        System.out.println("\nCity details using toString():");
        System.out.println(city);
    }
}
