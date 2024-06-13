package Model;

import Menu.Menu;
import Security.Gebruiker;

public class Vluchteling extends Gebruiker implements IVluchteling{
    private String voorNaam;
    private String achterNaam;
    private int leeftijd;
    private String gender;
    private Land geboorteLand;
    private Dossier dossier;
    private Gezin gezin;
    private Adres adres;

    public Vluchteling(String voorNaam,String achterNaam, String gender, Land geboorteLand, int leeftijd, Dossier dossier,String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "Vluchteling");
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.leeftijd = leeftijd;
        this.gender = gender;
        this.geboorteLand = geboorteLand;
        this.dossier = dossier;
        this.adres = new Adres("Ter Apelervenen", 10, "9561 MC",new Gemeente("Westerwolde", 0, 0));
    }

    public Vluchteling(){}

    @Override
    public void statusDossier() {
        System.out.println("Asielaanvraag is afgerond: " + (dossier.isAsielAanvraagCompleet() ? "Ja" : "Nee"));
        System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
        System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsWoning());
        System.out.println("Teruggekeerd naar het land van herkomst: " + (dossier.isTeruggekeerd() ? "Ja" : "Nee"));
    }

//    public void registerAdres(Adres nieuwAdres){
//        if(dossier.getPlaatsWoning().equals("Gestart")) {
//            nieuwAdres = new Adres("",null,"","");
//            adres = nieuwAdres;
//            dossier.setPlaatsWoning("Ja");
//        }
//    }

    public void notifyObservers(Bericht bericht){

    }

    //getters and setters


    public Dossier getDossier() {return dossier;}

    public String getVoorNaam() {
        return voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public Land getBirthCountry() {
        return geboorteLand;
    }

    public void setBirthCountry(Land geboorteLand) {
        this.geboorteLand = geboorteLand;
    }

//    public boolean isShowedPassport() {
//        return showedPassport;
//    }
//
//    public void setShowedPassport(boolean showedPassport) {
//        this.showedPassport = showedPassport;
//    }

    public void setGezin(Gezin gezin) {
        this.gezin = gezin;
    }
    public Gezin getGezin() {
        return gezin;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public Adres getAdres() {
        return adres;
    }

    public Land getGeboorteLand() {
        return geboorteLand;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public Menu inloggen() {
        return null;
    }
}
