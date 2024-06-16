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
//        this.dossier = new Dossier();
//        this.dossier.setAsielAanvraagCompleet(false);
//        this.dossier.setUitspraakIND("Geen");
//        this.dossier.setPlaatsWoning("Nee");
//        this.dossier.setTeruggekeerd(false);
        this.observers = new ArrayList<>();
    }

    public Vluchteling(String voorNaam, String achterNaam, String gender, Land geboorteLand, int leeftijd, Dossier dossier, String gebruikersnaam, String wachtwoord, Adres adres) {
        super(gebruikersnaam, wachtwoord, "Vluchteling");
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.leeftijd = leeftijd;
        this.gender = gender;
        this.geboorteLand = geboorteLand;
        this.dossier = dossier;
        this.adres = adres;
        this.observers = new ArrayList<>();
    }

    @Override
    public void statusDossier() {
        Dossier dossier = DataSeeder.getInstance().getDossierByGebruikersnaam(LoginC.getInstance().getaGebruiker().getGebruikersnaam());
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

    public void statusDossierVluchteling(Vluchteling vluchteling) {
        if(dossier != null){
            System.out.println();
            System.out.println("Status van Dossier van vluchteling "+ vluchteling.getVoorNaam() + " " + vluchteling.getAchterNaam() + ": ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Asielaanvraag is afgerond: " + (vluchteling.getDossier().isAsielAanvraagCompleet() ? "Ja" : "Nee"));
            System.out.println("Uitspraak IND: " + vluchteling.getDossier().getUitspraakIND());
            System.out.println("Plaatsing in eigen woning: " + vluchteling.getDossier().getPlaatsWoning());
            System.out.println("Teruggekeerd naar het land van herkomst: " + (vluchteling.getDossier().isTeruggekeerd() ? "Ja" : "Nee"));
        }else {
            System.out.println("Geen dossier gevonden voor deze vluchteling.");
        }
    }

    public void registerAdres(String straat, int nummer, String postcode, String gemeente){
        Dossier dossier = DataSeeder.getInstance().getDossierByGebruikersnaam(LoginC.getInstance().getaGebruiker().getGebruikersnaam());
        if (dossier != null){
            String pW = dossier.getPlaatsWoning().trim();

            if(pW.equalsIgnoreCase("Gestart")) {
                System.out.println("");
                Gemeente g = DataSeeder.getInstance().showGemeentes(gemeente);
                Adres nieuwAdres = new Adres(straat, nummer, postcode, g);
                adres = nieuwAdres;

                        System.out.println("Nieuwe adres:");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Straatnaam: " + adres.getStraat());
                System.out.println("Huisnummer: " + adres.getNummer());
                System.out.println("Postcode: " + adres.getPostcode());
                System.out.println("Gemeente: " + adres.getGemeente().getNaam());

                dossier.setPlaatsWoning("Afgerond");

                Vluchteling aG = (Vluchteling) LoginC.getInstance().getaGebruiker();
                aG.setDossier(dossier);
                DataSeeder.getInstance().updateVluchteling(aG);

                Bericht b = maakBericht("Vertrek","", aG.getVoorNaam(), aG.getAchterNaam());
                DataSeeder.getInstance().voegBerichtToe(b);
                notifyObservers(b);

                System.out.println("Veel geluk bij je nieuwe woning!");
                removeObservers();
            } else {
                System.out.println("De manier waarop je dossier aanroept klopt niet");
            }
        } else {
            System.out.println("Dossier is null");
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
        if(adres == null) {
            adres = new Adres("Ter Apelervenen", 10, "9561 MC", new Gemeente("Westerwolde", 0, 0));
        }

        System.out.println("Huidige adres:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Straatnaam: " + adres.getStraat());
        System.out.println("Huisnummer: " + adres.getNummer());
        System.out.println("Postcode: " + adres.getPostcode());
        System.out.println("Gemeente: " + adres.getGemeente().getNaam());

        System.out.println();

        Scanner scan =  new Scanner(System.in);
        System.out.println("Geef je nieuwe straatnaam: ");
        String straat = scan.nextLine();

        System.out.println("Geef je nieuwe huisnummer: ");
        int huisnummer = scan.nextInt();
        scan.nextLine();

        System.out.println("Geef je nieuwe postcode: ");
        String postcode1 = scan.nextLine();

        System.out.println("Geef je nieuwe gemeente van de volgende keuze (schrijf de naam volledig uit): ");
        for (Gemeente g : DataSeeder.getInstance().getGemeenten()){
            System.out.println(g.getNaam());
        }
        String gemeente = scan.nextLine();
        registerAdres(straat,huisnummer,postcode1,gemeente);
    }

    public void registreerObserver(Observer o){
        observers.add(o);
    }
    public void unRegistreerObserver(Observer o){
        observers.remove(o);
    }



    public Bericht maakBericht(String type, String azc, String voorNaam, String achterNaam){
        String naam = voorNaam + " " + achterNaam;
        String inhoud = "";

        String nieuwAZC;

        if(type.equalsIgnoreCase("Plaatsing")){
            nieuwAZC = azc;
            inhoud = "Vluchteling " + naam + " wordt in " + nieuwAZC + " geplaatst.";
           return new Bericht(azc,naam,true,inhoud);
        } else if (type.equalsIgnoreCase("Verhuizing")){
            nieuwAZC = azc;
            inhoud = "Vluchteling " + naam + " wordt naar " + nieuwAZC + " verhuist.";
            return new Bericht(nieuwAZC,naam,true,inhoud, type);
        } else if (type.equalsIgnoreCase("Vertrek")){
            inhoud = "Vluchteling " + naam + " vertrekt.";
            return new Bericht(naam, true,inhoud, type);
        }
        return null;
    }

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

        Vluchteling vluchteling = DataSeeder.getInstance().getVluchtelingByNaam(vVoornaam, vAchternaam);

        String naam = vluchteling.getVoorNaam() + " " + vluchteling.getAchterNaam();

        Bericht b = new Bericht(naam, true, naam + " verterkt naar land van herkomst." ,"Vertrek");
        DataSeeder.getInstance().voegBerichtToe(b);
        notifyObservers(b);

        Dossier d = v.getDossier();
        v.setDossier(d);
        DataSeeder.getInstance().updateVluchteling(v);

        System.out.println("Vertrek naar het land van herkomst geregistreerd voor " + v.getVoorNaam() + " " + v.getAchterNaam());
    }

    public void notifyObservers(Bericht b){
        for (Observer o : observers){
            o.update(b);
        }
        System.out.println("it works!");
    }

    public static Vluchteling getInstance() {
        if(instance==null){
            instance = new Vluchteling();
        }
        return instance;
    }

    public boolean isPlaatsingGestart(){
        Dossier dossier = DataSeeder.getInstance().getDossierByGebruikersnaam(LoginC.getInstance().getaGebruiker().getGebruikersnaam());
        return dossier != null && (dossier.getPlaatsWoning().equalsIgnoreCase("Gestart")||dossier.getPlaatsWoning().equalsIgnoreCase("Afgerond"));
    }

    public void setAzc(AZC azc) {
        this.azc = azc;
    }

    public AZC getAzc() {
        return azc;
    }

    public Dossier getDossier() {return this.dossier;}

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
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

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }
}
