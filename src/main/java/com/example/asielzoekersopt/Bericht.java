package com.example.asielzoekersopt;

public class Bericht {
    private String naamAZC;
    private String naamVluchteling;
    private boolean isRelevant;

    public Bericht(String naamAZC, String naamVluchteling, boolean isRelevant) {
        this.naamAZC = naamAZC;
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
    }


    //getters & setters
    public String getNaamAZC() {
        return naamAZC;
    }

    public String getNaamVluchteling() {
        return naamVluchteling;
    }

    public void setRelevant(boolean relevant) {
        isRelevant = relevant;
    }

    public boolean isRelevant() {
        return isRelevant;
    }
}
