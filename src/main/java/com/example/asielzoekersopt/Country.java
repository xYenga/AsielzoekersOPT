package com.example.asielzoekersopt;

public class Country {
    private String name;
    private boolean safe;

    //Methoden
    public Country(String name, boolean safe){
        this.name=name;
        this.safe=safe;
    }

    //getters en setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isSafe() {
        return safe;
    }
}
