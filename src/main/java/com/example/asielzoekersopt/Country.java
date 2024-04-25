package com.example.asielzoekersopt;

public class Country {
    private String name;
    private boolean safe;


    public String getName() {
        return name;
    }

    public Country(String name, boolean safe){
        this.name=name;
        this.safe=safe;
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
