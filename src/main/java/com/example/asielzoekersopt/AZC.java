package com.example.asielzoekersopt;

import java.util.ArrayList;

public class AZC implements IManage{
    private Adres adres;
    private Gemeente gemeente;
    private ArrayList<Vluchteling> vluchtelingen;

    public AZC(Adres adres, Gemeente gemeente, String postcode){
        this.adres = adres;
        this.gemeente = gemeente;
        this.vluchtelingen = new ArrayList<>();
    }


    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }
}
