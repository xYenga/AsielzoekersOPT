package com.example.asielzoekersopt;

public class DataSeeder {
    private static DataSeeder instance = null;

    private void initialize(){

    }

    private DataSeeder(){

        initialize();
    }
    public static DataSeeder getInstance(){
        if(instance == null){
            instance = new DataSeeder();
        }
        return instance;
    }
}
