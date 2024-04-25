package com.example.asielzoekersopt;

import java.util.ArrayList;

public class Gemeente {
    private String name;
    private int inwoners;
    private ArrayList<Gemeente> uitkeringen;

    public Gemeente(int inwoners, ArrayList<Gemeente> uitkeringen) {
        this.inwoners = inwoners;
        this.uitkeringen = uitkeringen;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getInwoners() {
        return inwoners;
    }
    public void setInwoners(int inwoners) {
        this.inwoners = inwoners;
    }

}
