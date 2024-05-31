package com.example.asielzoekersopt;

public abstract class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;


    //methods
    public abstract String Inloggen(String gebruikersnaam, String wachtwoord){
        if(gebruikersnaam && wachtwoord){}
    }
}
