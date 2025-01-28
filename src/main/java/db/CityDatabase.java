package db;

import db.interfaces.ICityDatabase;
import exceptions.CityNotFoundException;
import models.City;
import models.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CityDatabase implements ICityDatabase {
    private Connection con = null;

    private HashMap<Integer, City> cityCache = new HashMap<>();
    private HashMap<String, Weather> weatherCache = new HashMap<>();

    @Override
    public void connect(String connectionUrl, String user, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl,user,pass);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }