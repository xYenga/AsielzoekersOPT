package com.example.asielzoekersopt;

import java.util.ArrayList;
import java.util.List;

public class Gezin {
    private List<Gezin> leden;

    public Gezin() {
        this.leden = new ArrayList<>();
    }

    public void voegFamilieLid(Gezin gezin){
        this.leden.add(gezin);
    }
    public List<Gezin> getLeden() {
        return leden;
    }
}
