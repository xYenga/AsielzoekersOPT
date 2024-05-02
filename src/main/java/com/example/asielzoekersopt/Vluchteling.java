package com.example.asielzoekersopt;

public class Vluchteling extends Gebruiker{
    private String name;
    private Land geboorteLand;
    private boolean showedPassport;

    public Vluchteling(String name, Land geboorteLand, boolean showedPassport) {
        this.name = name;
        this.geboorteLand = geboorteLand;
        this.showedPassport = showedPassport;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Land getBirthCountry() {
        return geboorteLand;
    }

    public void setBirthCountry(Land geboorteLand) {
        this.geboorteLand = geboorteLand;
    }

    public boolean isShowedPassport() {
        return showedPassport;
    }

    public void setShowedPassport(boolean showedPassport) {
        this.showedPassport = showedPassport;
    }
}
