package Model;

import com.example.asielzoekersopt.Observer;

import java.util.ArrayList;

public class AZC implements Observer {
    private String naam;
    private Adres adres;
    private ArrayList<Kamer> kamers;
    private ArrayList<Bericht> berichtenbox;

    public AZC(String naam, Adres adres){
        this.naam = naam;
        this.adres = adres;
        this.kamers = new ArrayList<>();
        this.berichtenbox = new ArrayList<>();
    }

    public String nietVerwerkteBerichten(){
        return null;
    }
    public String selecteerBericht(){
        return null;
    }

    public void voegBericht(Bericht bericht){
        berichtenbox.add(bericht);
    }
    public void verwijderBericht(Bericht bericht){
        berichtenbox.remove(bericht);
    }

    public void voegKamers(Kamer kamer){
        kamers.remove(kamer);
    }
    public void verwijderKamers(Kamer kamer){
        kamers.add(kamer);
    }


    @Override
    public void update(Bericht bericht) {
        voegBericht(bericht);
    }

    //getters & setters
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public ArrayList<Bericht> getBerichtenbox() {
        return berichtenbox;
    }

    public int getAantalVluchtelingen() {
        int aantalVluchtelingen = 0;
        for (Kamer kamer : kamers) {
            aantalVluchtelingen += kamer.getAantalVluchtelingenGevestigd();
        }
        return aantalVluchtelingen;
    }
}
