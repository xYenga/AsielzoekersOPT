package Model;

import Menu.Menu;
import Security.Gebruiker;
import Security.DataSeeder;
import Security.LoginC;

import java.util.ArrayList;
import java.util.Scanner;

public class Vluchteling extends Gebruiker implements IVluchteling{

    private static Vluchteling instance = null;
    private String voorNaam;
    private String achterNaam;
    private int leeftijd;
    private String gender;
    private Land geboorteLand;
    private Dossier dossier;
    private Gezin gezin;
    private Adres adres;
    private AZC azc;

    private ArrayList<Observer> observers;

    public Vluchteling(String voorNaam,String achterNaam, String gender, Land geboorteLand, int leeftijd, Dossier dossier,String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "Vluchteling");
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.leeftijd = leeftijd;
        this.gender = gender;
        this.geboorteLand = geboorteLand;
        this.dossier = dossier;
        this.adres = new Adres("Ter Apelervenen", 10, "9561 MC",new Gemeente("Westerwolde", 0, 0));
        this.observers = new ArrayList<>();
    }

    public Vluchteling(){
        this.dossier = new Dossier();
        this.dossier.setAsielAanvraagCompleet(false);
        this.dossier.setUitspraakIND("Geen");
        this.dossier.setPlaatsWoning("Nee");
        this.dossier.setTeruggekeerd(false);
        this.observers = new ArrayList<>();
    }

    @Override
    public void statusDossier() {
        if(dossier != null){
            System.out.println();
            System.out.println("Status van Dossier:");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Asielaanvraag is afgerond: " + (dossier.isAsielAanvraagCompleet() ? "Ja" : "Nee"));
            System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
            System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsWoning());
            System.out.println("Teruggekeerd naar het land van herkomst: " + (dossier.isTeruggekeerd() ? "Ja" : "Nee"));
        }else {
            System.out.println("Geen dossier gevonden voor deze vluchteling.");
        }
    }

    public void registerAdres(String straat, int nummer, String postcode, String gemeente){
        if(dossier.getPlaatsWoning().equals("Gestart")) {
            Gemeente g = DataSeeder.getInstance().showGemeentes(gemeente);
            Adres nieuwAdres = new Adres(straat,nummer,postcode, g);
            adres = nieuwAdres;
            dossier.setPlaatsWoning("Afgerond");
            dossier.plaatsingWoning(false);

            notifyObservers();

            System.out.println("Veel geluk bij je nieuwe woning!");
            removeObservers();
        }
    }

    public void removeObservers(){
        for (Observer observer : observers) {
            if (observer instanceof AZC) {
                unRegistreerObserver(observer);
            }
        }
    }

    public void adresRegistreren(){
        Scanner scan =  new Scanner(System.in);
        System.out.println("Geef je nieuwe straatnaam: ");
        String straat = scan.nextLine();

        System.out.println("Geef je nieuwe huisnummer: ");
        int huisnummer = scan.nextInt();

        System.out.println("Geef je nieuwe postcode: ");
        String postcode = scan.nextLine();

        System.out.println("Geef je nieuwe gemeente: ");
        String gemeente = scan.nextLine();

        registerAdres(straat,huisnummer,postcode,gemeente);
    }

    public void registreerObserver(Observer o){
        observers.add(o);
    }
    public void unRegistreerObserver(Observer o){
        observers.remove(o);
    }

//    public Bericht maakBericht(String ){
//        String naam = voorNaam + " " + achterNaam;
//        Scanner scan = new Scanner(System.in);
//        System.out.println();
//        int keuze = scan.nextInt();
//
//        AZC nieuwAZC = ;
//        AZC oudAZC = ;
//
//        if(){
//            String inhoud = "Vluchteling " + naam + " wordt in " + nieuwAZC + " geplaatst.";
//            return new Bericht(azc,naam,true,inhoud);
//        } else if (){
//            String inhoud = "Vluchteling " + naam + " wordt van " + oudAZC + " naar " + nieuwAZC + " veplaatst.";
//            return new Bericht(azc,naam,true,inhoud);
//        } else if (){
//            String inhoud = "Vluchteling " + naam + " vertrekt terug naar land van herkomst.";
//            return new Bericht(naam,true,inhoud);
//        }
//        return null;
//    }

    public void vertrekNaarLandVanHerkomst(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoornaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchternaam = scan.nextLine();

        Vluchteling v = COA.getInstance().zoekVluchteling(vVoornaam, vAchternaam);

        if (v == null) {
            System.out.println("Vluchteling niet gevonden.");
            return;
        }

        v.getDossier().setTeruggekeerd(true);

        Bericht b = new Bericht( v.getVoorNaam() + " " + v.getAchterNaam(), true, v.getVoorNaam() + " " + v.getAchterNaam() + " vertrek naar land van herkomst", "vertrek");
        for (Observer o : observers){
            o.update(b);
        }

        System.out.println("Vertrek naar het land van herkomst geregistreerd voor " + v.getVoorNaam() + " " + v.getAchterNaam());
    }

    public void notifyObservers(){
        String naam = voorNaam + " " + achterNaam;
        String inhoud = "Vluchteling " + naam + " verhuisd naar een eigen woning.";
        Bericht b =  new Bericht(naam,true,inhoud, "vertrek");
        for (Observer o : observers){
            o.update(b);
        }
    }

    public static Vluchteling getInstance() {
        if(instance==null){
            instance = new Vluchteling();
        }
        return instance;
    }

    public void setAzc(AZC azc) {
        this.azc = azc;
    }

    public AZC getAzc() {
        return azc;
    }

    public Dossier getDossier() {return dossier;}

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public boolean isPlaatsingInEigenWoningGestart() {
        return this.dossier.getPlaatsWoning().equalsIgnoreCase("Gestart");
    }

    public void setGezin(Gezin gezin) {
        this.gezin = gezin;
    }
    public Gezin getGezin() {
        return gezin;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }
}
