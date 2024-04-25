package com.example.asielzoekersopt;

import java.util.ArrayList;

public class Gemeente {
    private String name;
    private int aantalInwoners;
    private int aangebodenPlaatsen;
    private ArrayList<Gemeente> uitkeringen;

    public Gemeente(String name,int aantalInwoners, ArrayList<Gemeente> uitkeringen) {
        this.name = name;
        this.aantalInwoners = aantalInwoners;
        this.uitkeringen = uitkeringen;
    }

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
}
