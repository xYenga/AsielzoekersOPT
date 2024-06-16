package Model;

import Menu.Menu;
import Security.Gebruiker;
import Security.DataSeeder;
import Security.LoginC;

import java.util.ArrayList;
import java.util.Scanner;

public class Vluchteling extends Gebruiker{
    Scanner scan =  new Scanner(System.in);
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
    private VluchtelingDossier vD;
    private VluchtelingObservers oV;
    private MaakAdres mK;

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
        this.oV = new VluchtelingObservers();
        this.vD = new VluchtelingDossier(dossier);

    }

    public Vluchteling(){
        this.oV = new VluchtelingObservers();
        this.observers = new ArrayList<>();
        this.vD = new VluchtelingDossier(dossier);
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
        this.vD = new VluchtelingDossier(dossier);
        this.oV = new VluchtelingObservers();
    }

    public void statusDossier() {
        Dossier dossier = DataSeeder.getInstance().getDossierByGebruikersnaam(LoginC.getInstance().getaGebruiker().getGebruikersnaam());
        if(dossier != null){
            vD.setDossier(dossier);
            vD.printStatusDossier();
        }else {
            System.out.println("Geen dossier gevonden voor deze vluchteling.");
        }
    }

    public void registerAdres(Adres nieuwAdres){
        Dossier dossier = DataSeeder.getInstance().getDossierByGebruikersnaam(LoginC.getInstance().getaGebruiker().getGebruikersnaam());
        mK.nieuwAdres(nieuwAdres);
        if (dossier != null){
            String pW = dossier.getPlaatsWoning().trim();

            if(pW.equalsIgnoreCase("Gestart")) {
                dossier.setPlaatsWoning("Afgerond");

                updateVluchtelingDossier(dossier);

                Vluchteling aG = (Vluchteling) LoginC.getInstance().getaGebruiker();

                Bericht b = maakBericht("Vertrek","", aG.getVoorNaam(), aG.getAchterNaam());
                DataSeeder.getInstance().voegBerichtToe(b);
                oV.notifyObservers(b);

                System.out.println("Veel geluk bij je nieuwe woning!");
                oV.removeObservers();
            } else {
                System.out.println("De manier waarop je dossier aanroept klopt niet");
            }
        } else {
            System.out.println("Dossier is null");
        }
    }

    private void updateVluchtelingDossier(Dossier d){
        this.vD.setDossier(d);
        DataSeeder.getInstance().updateVluchteling(this);
    }


    public void adresRegistreren(){
        if (mK == null) {
            mK = new MaakAdres();
        }

        Adres huidigAdres = mK.getAdres();
        if(huidigAdres == null) {
            huidigAdres = new Adres("Ter Apelervenen", 10, "9561 MC", new Gemeente("Westerwolde", 0, 0));
            mK.setAdres(huidigAdres);
        }

        mK.printAdres();
        Adres nieuwAdres = vulAdres();
        registerAdres(nieuwAdres);
    }

    public Adres vulAdres(){
        System.out.println("Geef je nieuwe straatnaam: ");
        String straat = scan.nextLine();

        System.out.println("Geef je nieuwe huisnummer: ");
        int huisnummer = scan.nextInt();
        scan.nextLine();

        System.out.println("Geef je nieuwe postcode: ");
        String postcode1 = scan.nextLine();

        System.out.println("Geef je nieuwe gemeente van de volgende keuze (schrijf de naam volledig uit): ");
        for (Gemeente g : DataSeeder.getInstance().getGemeenten()){
            System.out.println(" - " + g.getNaam());
        }
        String gemeente = scan.nextLine();
        Gemeente g = DataSeeder.getInstance().showGemeentes(gemeente);
        return new Adres(straat,huisnummer,postcode1,g);
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
        System.out.println("Geef de voornaam van de vluchteling: ");
        String voorNaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String achterNaam = scan.nextLine();

        Vluchteling v = COA.getInstance().zoekVluchteling(voorNaam, achterNaam);
        if (v == null) {
            System.out.println("Vluchteling niet gevonden.");
            return;
        }
        registreerVertrekVluchteling(v, voorNaam, achterNaam);
    }

    public void registreerVertrekVluchteling(Vluchteling v, String voorNaam, String achterNaam){
        v.getDossier().setTeruggekeerd(true);

        Vluchteling vluchteling = DataSeeder.getInstance().getVluchtelingByNaam(voorNaam, achterNaam);
        String naam = vluchteling.getVoorNaam() + " " + vluchteling.getAchterNaam();

        Bericht b = new Bericht(naam, true, naam + " verterkt naar land van herkomst." ,"Vertrek");
        DataSeeder.getInstance().voegBerichtToe(b);
        notifyObservers(b);

        Dossier d = v.getDossier();
        v.setDossier(d);
        updateVluchtelingDossier(d);

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

    public int getLeeftijd() {
        return leeftijd;
    }

    public VluchtelingObservers getoV() {
        return oV;
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }
}
