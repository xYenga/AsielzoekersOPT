package com.example.asielzoekersopt;

import java.util.ArrayList;

public class AZC implements SQL{
    private String straat;
    private int nummer;
    private String postcode;
    Gemeente gemeente;
    private ArrayList<Vluchteling> vluchtelingen;

    public AZC(String straat, int nummer, String postcode){

        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;

    }

    public String adres(){
        return straat + nummer + postcode + gemeente.getName();
    }

    public void total(){}


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
