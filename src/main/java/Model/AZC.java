package Model;

import Security.DataSeeder;

import java.util.ArrayList;

import java.util.Scanner;

public class AZC implements Observer {
    private String naam;
    private Adres adres;
    private ArrayList<Kamer> kamers;
    private ArrayList<Bericht> berichtenbox;
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public AZC(String naam, Adres adres){
        this.naam = naam;
        this.adres = adres;
        this.kamers = new ArrayList<>();
        this.berichtenbox = new ArrayList<>();
    }
    public AZC(){}

    public String selecteerBericht(){
        DataSeeder seeder = DataSeeder.getInstance();
        toonBerichtenBox();
        Scanner scan = new Scanner(System.in);
        System.out.println("Selecteer welke bericht u wilt zien.");
        int keuze = scan.nextInt();
            
        Bericht b = selecteerBericht(keuze);
        boolean relevant = true;
        System.out.println(b);

        System.out.println("Wat wilt u doen met deze bericht?: ");
        System.out.println("1. Toepassing van het bericht");
        System.out.println("2. Cancel");
        int keuze2 = scan.nextInt();
        if(keuze2 == 1){
            Vluchteling v = seeder.getVluchteling(b.getNaamVluchteling());
            if(v != null){
                Gezin g = v.getGezin();
                if (b.getType().equalsIgnoreCase("vertrek")){
                    geefSlaapplaatsVrij(v);
                    if (g != null){
                        for (Vluchteling gV : g.getGezinsleden()){
                            geefSlaapplaatsVrij(gV);
                            relevant = false;
                        }
                    }
                } else if (b.getType().equalsIgnoreCase("plaatsing")) {
                    wijsKamerToe(v);
                    if (g != null){
                        for (Vluchteling gV : g.getGezinsleden()){
                            wijsKamerToe(gV);
                            relevant = false;
                        }
                    }
                }
                verwijderBericht(b, relevant);
            } else {
                System.out.println("Geen vluchteling gevonden.");
            }
        } else if(keuze2 == 2){
            return null;
        }
        return null;
    }

    public Bericht selecteerBericht(int index) {
        if (index >= 1 && index <= berichtenbox.size()) {
            Bericht bericht = berichtenbox.get(index - 1);
            System.out.println("Gaat het om de plaatsing of om het vertrek van een vluchteling? " + bericht.getType());
            System.out.println("De naam van de vluchteling: " + bericht.getNaamVluchteling());
            System.out.println("De eventuele namen van de vluchtelingen uit hetzelfde gezin: ");
            Gezin g = showList(bericht.getNaamVluchteling());
            if (g != null) {
                for (Vluchteling gezinslid : g.getGezinsleden()) {
                    System.out.println(gezinslid.getVoorNaam() + " " + gezinslid.getAchterNaam());
                }
            }
            return bericht;
        }
        return null;
    }

    public Gezin showList(String naam){
        DataSeeder seeder = DataSeeder.getInstance();
        for (Vluchteling v : seeder.getVluchtelingen()){
            String name = v.getVoorNaam() +" "+ v.getAchterNaam();
            if (name.equals(naam)){
                return v.getGezin();
            }
        }
        return null;
    }

    public void voegBericht(Bericht bericht){
        berichtenbox.add(bericht);
    }
    public void verwijderBericht(Bericht bericht, boolean relevant){
        if(!relevant) {
            berichtenbox.remove(bericht);
        }
    }

    public void toonBerichtenBox(){
        zetBerichtenBoxOp(getNaam());
    }

    public void zetBerichtenBoxOp(String azc){
        if (azc.equalsIgnoreCase(getNaam())){
            index = 1;
            for(Bericht b : berichtenbox){
                if(b.isRelevant() && isVluchtelingGeregistreerd(b)){
                    System.out.println(index + ". " + b);
                    index++;
                }
            }
            setIndex(index);
        }
    }

    private boolean isVluchtelingGeregistreerd(Bericht bericht) {
        DataSeeder seeder = DataSeeder.getInstance();
        Vluchteling vluchteling = seeder.getVluchteling(bericht.getNaamVluchteling());
        if (vluchteling != null) {
            for (Kamer kamer : kamers) {
                if (kamer.getVluchtelingen().contains(vluchteling)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void voegVluchtelingToe(Vluchteling vluchteling) {
        for (Kamer kamer : kamers) {
            if (kamer.toewijzingRegel(vluchteling)) {
                kamer.voegVluchtelingToe(vluchteling);
                return;
            }
        }
        System.out.println("Geen geschikte kamer beschikbaar voor " + vluchteling.getVoorNaam() +" "+ vluchteling.getAchterNaam());
    }

    public void verwijderVluchteling(Vluchteling vluchteling) {
        for (Kamer kamer : kamers) {
            if (kamer.verwijderVluchteling(vluchteling)) {
                break;
            }
        }
    }

    public void wijsKamerToe(Vluchteling vluchteling) {
        for (Kamer kamer : kamers) {
            if (kamer.toewijzingRegel(vluchteling)) {
                kamer.voegVluchtelingToe(vluchteling);
                return;
            }
        }
        System.out.println("Geen geschikte kamer beschikbaar voor " + vluchteling.getVoorNaam() +" "+ vluchteling.getAchterNaam());
    }
    public void geefSlaapplaatsVrij(Vluchteling vluchteling) {
        for (Kamer kamer : kamers) {
            if (kamer.verwijderVluchteling(vluchteling)) {
                break;
            }
        }
    }

    public int getAantalVluchtelingen() {
        int aantalVluchtelingen = 0;
        for (Kamer kamer : kamers) {
            aantalVluchtelingen += kamer.getAantalVluchtelingenGevestigd();
        }
        return aantalVluchtelingen;
    }

    public void voegKamer(Kamer kamer) {
        kamers.add(kamer);
    }

    @Override
    public void update(Bericht bericht) {
        voegBericht(bericht);
    }

    public void krijgBericht(Bericht b) {

    }
}
