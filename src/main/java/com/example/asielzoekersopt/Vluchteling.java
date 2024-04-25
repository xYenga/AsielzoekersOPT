package com.example.asielzoekersopt;

public class Vluchteling {
    private String name;
    private Country birthCountry;
    private boolean showedPassport;

    public Vluchteling(String name, Country birthCountry, boolean showedPassport) {
        this.name = name;
        this.birthCountry = birthCountry;
        this.showedPassport = showedPassport;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(Country birthCountry) {
        this.birthCountry = birthCountry;
    }

    public boolean isShowedPassport() {
        return showedPassport;
    }

    public void setShowedPassport(boolean showedPassport) {
        this.showedPassport = showedPassport;
    }
}
