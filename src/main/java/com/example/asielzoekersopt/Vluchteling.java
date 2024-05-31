package com.example.asielzoekersopt;

public class Vluchteling extends Gebruiker{
    private String naam;
    private int leeftijd;
    private String gender;
    private Land geboorteLand;
    private Dossier dossier;
    private Gezin gezin;
    private Adres adres;

    public Vluchteling(String naam, String gender, Land geboorteLand, int leeftijd, Dossier dossier, Gezin gezin, Adres adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.gender = gender;
        this.geboorteLand = geboorteLand;
        this.dossier = new Dossier();
        this.gezin = gezin;
        this.adres = new Adres("Ter Apelervenen", 10, "9561 MC",new Gemeente("Westerwolde", 0, 0));
    }

    public void statusDossier() {
        if(dossier.isAsielAanvraagCompleet()) {
            System.out.println("Asielaanvraag is isafgerond?: ja");
        } else {
            System.out.println("Is asielaanvraag van de vluchteling afgerond?: nee");
        }
        System.out.println("Is" + dossier.getUitspraakIND());
        System.out.println("Wordt vluchteling in een eigen woning geplaatst?: " + dossier.getPlaatsWoning());
        if (dossier.isTeruggekeerd()) {
            System.out.println("Is vluchteling teruggekeerd naar land van herkomst?: Ja");
        } else {
            System.out.println("Is vluchteling teruggekeerd naar land van herkomst?: Nee");
        }
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
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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
}
