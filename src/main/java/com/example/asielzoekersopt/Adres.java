package com.example.asielzoekersopt;

public class Adres {
    private String straat;
    private int nummer;
    private String postcode;

    public Adres(String straat, int nummer, String postcode){
        this.straat=straat;
        this.nummer=nummer;
        this.postcode=postcode;
    }

    public String getStraat() {
        return straat;
    }

    public int getNummer() {
        return nummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
