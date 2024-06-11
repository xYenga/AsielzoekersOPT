package Model;

public class Vluchteling{
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
        this.dossier = dossier;
        this.gezin = gezin;
        this.adres = new Adres("Ter Apelervenen", 10, "9561 MC",new Gemeente("Westerwolde", 0, 0));
    }

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
