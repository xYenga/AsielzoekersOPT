package com.example.asielzoekersopt;

public class Dossier {
    boolean asielAanvraagCompleet;
    String uitspraakIND;
    String plaatsWoning;
    boolean teruggekeerd;

    public Dossier(){
        this.asielAanvraagCompleet = false;
        this.uitspraakIND = "geen";
        this.plaatsWoning = "nee";
        this.teruggekeerd = false;
    }

    //methods
    public void modifyUitspraak(){

    }

    //getters & setters
    public String getPlaatsWoning() {
        return plaatsWoning;
    }

    public String getUitspraakIND() {
        return uitspraakIND;
    }

    public boolean isAsielAanvraagCompleet() {
        return asielAanvraagCompleet;
    }

    public boolean isTeruggekeerd() {
        return teruggekeerd;
    }
}
