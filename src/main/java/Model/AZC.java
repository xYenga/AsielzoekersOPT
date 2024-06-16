package Model;

import Security.DataSeeder;

import java.util.ArrayList;

import java.util.Scanner;

public class AZC implements Observer {
    private String naam;
    private Adres adres;
    private ArrayList<Kamer> kamers;
    private ArrayList<Bericht> berichtenbox;
    Scanner scan = new Scanner(System.in);
    DataSeeder seeder = DataSeeder.getInstance();

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
    private int vraagKeuze(String vraag){
        System.out.println(vraag);
        int keuze = scan.nextInt();
        scan.nextLine();
        return keuze;
    }

    public void selecteerBericht(){
        toonBerichtenBox();
        int keuze = vraagKeuze("Selecteer welke bericht u wilt zien.");

        Bericht b = selecteerBericht(keuze);
        System.out.println(b);

        int keuze2 = vraagKeuze("Wat wilt u doen met deze bericht?: \n1. Toepassing van het bericht\n2. Cancel");

        if(keuze2 == 1){
            verwerkBericht(b);
        }
    }

    public Bericht selecteerBericht(int index) {
        if (index >= 1 && index <= DataSeeder.getInstance().getBerichten().size()) {
            Bericht bericht = DataSeeder.getInstance().getBerichten().get(index - 1);
            toonBerichtInfo(bericht);
            return bericht;
        }
        return null;
    }

    public void toonBerichtInfo(Bericht bericht){
        System.out.println("Gaat het om de plaatsing of om het vertrek van een vluchteling? " + bericht.getType());
        System.out.println("De naam van de vluchteling: " + bericht.getNaamVluchteling());
        System.out.println("De eventuele namen van de vluchtelingen uit hetzelfde gezin: ");
        Gezin g = showList(bericht.getNaamVluchteling());
        if (g != null) {
            for (Vluchteling gezinslid : g.getGezinsleden()) {
                System.out.println(gezinslid.getVoorNaam() + " " + gezinslid.getAchterNaam());
            }
        }
    }

    public void verwerkBericht(Bericht b){
        if (b.getType() == null) {
            System.out.println("Het berichttype is null.");
            return;
        }

        Vluchteling v = seeder.getVluchteling(b.getNaamVluchteling());
        if (v != null) {
            Gezin g = v.getGezin();
            if (b.getType().equalsIgnoreCase("vertrek")) {
                geefSlaapplaatsVrij(v);
                if (g != null) {
                    for (Vluchteling gV : g.getGezinsleden()) {
                        geefSlaapplaatsVrij(gV);
                    }
                    System.out.println("Kamer is vrijgemaakt.");
                }
            } else if (b.getType().equalsIgnoreCase("plaatsing")) {
                wijsKamerToe(v);
                if (g != null) {
                    for (Vluchteling gV : g.getGezinsleden()) {
                        wijsKamerToe(gV);
                    }
                    System.out.println("Kamer is gegeven aan de vluchteling(en).");
                }
            }
            verwijderBericht(b, false);
            System.out.println("\nBericht is verwijderd uit de berichtenbox.");
        } else {
            System.out.println("Geen vluchteling gevonden.");
        }
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
            DataSeeder.getInstance().verwijderBericht(bericht);
        }
    }

    public void toonBerichtenBox(){
        System.out.println("Berichten in de berichtenbox:");
        zetBerichtenBoxOp();
    }

    public void zetBerichtenBoxOp(){
        index = 1;
        for(Bericht b : DataSeeder.getInstance().getBerichten()){
            toonBericht(index, b);
            index++;
           }
        setIndex(index);
    }

    private void toonBericht(int index, Bericht b){
        System.out.println(index + ". " + b.showBericht(b));
    }


    public void voegVluchtelingToe(Vluchteling vluchteling) {
        for (Kamer kamer : kamers) {
            if (kamer.toewijzingRegel(vluchteling)) {
                kamer.voegVluchtelingToe(vluchteling, kamer);
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
                kamer.voegVluchtelingToe(vluchteling, kamer);
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

}
