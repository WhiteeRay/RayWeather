import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.CityDatabase;
import models.City;
import models.Weather;
import org.w3c.dom.ls.LSOutput;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MyApplication {
    public static void main(String[] args) {

        CityDatabase db = new CityDatabase();
        db.connect("jdbc:postgresql://localhost:5432/" + "postgres", "postgres", "0000");
        Scanner sc = new Scanner(System.in);
        String place_id;
        System.out.println("Welcome");
        boolean t = true;
        while(t){
            try{
                System.out.println("[1] View all cities");
                System.out.println("[2] Get cities by id");
                System.out.println("[3] Exit");

                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        ArrayList<City> cities = db.getAllCities();
                        for(City city : cities){
                            city.displayInfo();
                        }
                        break;
                    case 2:
                        System.out.println("Enter ID: ");
                        place_id = db.getCityById(sc.nextInt());
                        String token = "wj41qlc7ukds7tj5n2iisohhfxu843nhepoxmpz8";
                        Weather weather = getWeather(token, place_id);
                        System.out.println(weather);
                        break;
                    case 3:
                        t = false;
                        break;
                    default:
                        System.out.println("Please select option between 1-3.");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Input must be integer " + e.getMessage());

            }catch(Exception e){
                System.out.println("Exception " + e.getMessage());
            }
        }
            }
                }