package com.example.asielzoekersopt;

import java.util.ArrayList;
import java.util.List;

public class Gezin {
    private Vluchteling gezinshoofd;

    public Gezin(Vluchteling gezinshoofd) {
        this.gezinshoofd = gezinshoofd;
    }
    
    public List<Gezin> getLeden() {
        return leden;
    }
}
