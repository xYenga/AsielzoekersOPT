package com.example.asielzoekersopt;

import java.util.ArrayList;
import java.util.List;

public class Gemeente{
    private String name;
    private int aantalInwoners;
    private int aangebodenPlaatsen;
    private List<AZC> azcs;

    public Gemeente(String name,int aantalInwoners, int aangebodenPlaatsen) {
        this.name = name;
        this.aantalInwoners = aantalInwoners;
        this.aangebodenPlaatsen = aangebodenPlaatsen;
        this.azcs = new ArrayList<>();
    }

    public void addAZC(AZC azc){
        azcs.add(azc);
    }

    //getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }
    public void setAantalInwoners(int inwoners) {
        this.aantalInwoners = inwoners;
    }

    public int getAangebodenPlaatsen() {
        return aangebodenPlaatsen;
    }
    public void setAangebodenPlaatsen(int aangebodenPlaatsen) {
        this.aangebodenPlaatsen = aangebodenPlaatsen;
    }
    public List<AZC> getAzcs(){
        return azcs;
    }
}
