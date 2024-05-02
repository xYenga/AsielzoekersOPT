package com.example.asielzoekersopt;

public class Land implements IManage{
    private String name;
    private boolean veilig;

    //constructor
    public Land(String name, boolean safe){
        this.name=name;
        this.veilig=safe;
    }

    //methods


    //getters en setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVeilig(boolean safe) {
        this.veilig = safe;
    }

    public boolean isVeilig() {
        return veilig;
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
