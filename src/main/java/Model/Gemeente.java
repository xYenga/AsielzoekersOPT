package Model;

import java.util.ArrayList;
import java.util.List;

public class Gemeente{
    private String naam;
    private int aantalInwoners;
    private int aangebodenPlaatsen;
    private List<AZC> azcs;

    public Gemeente(String name,int aantalInwoners, int aangebodenPlaatsen) {
        this.naam = name;
        this.aantalInwoners = aantalInwoners;
        this.aangebodenPlaatsen = aangebodenPlaatsen;
        this.azcs = new ArrayList<>();
    }

    public void addAZC(AZC azc){
        azcs.add(azc);
    }

    //getters & setters
    public String getNaam() {
        return naam;
    }
    public void setNaam(String name) {
        this.naam = name;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }
    public void setAantalInwoners(int inwoners) {
        this.aantalInwoners = inwoners;
    }

    public int getAangebodenPlaatsen() {
        return aangebodenPlaatsen;
    }
    public void setAangebodenPlaatsen(int aangebodenPlaatsen) {
        this.aangebodenPlaatsen = aangebodenPlaatsen;
    }
    public List<AZC> getAzcs(){
        return azcs;
    }

    public int getAantalVluchtelingen() {
        int aantalVluchtelingen = 0;
        for (AZC azc : azcs) {
            aantalVluchtelingen += azc.getAantalVluchtelingen();
        }
        return aantalVluchtelingen;
    }
}
