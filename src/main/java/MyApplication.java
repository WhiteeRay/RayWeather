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
    }
}