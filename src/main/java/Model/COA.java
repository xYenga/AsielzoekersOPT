package Model;

import Security.DataSeeder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class COA {
    DataSeeder seeder = DataSeeder.getInstance();
    private static COA instance = null;
    private ArrayList<Vluchteling> vluchtelingen;

    public COA(){
        vluchtelingen = seeder.getVluchtelingen();
    }

    public void registreerVluchteling(){
        System.out.println("Vul de gegevens van de Vluchteling in: ");
        Scanner scan = new Scanner(System.in);

        System.out.println("Voornaam: ");
        String voorNaam = scan.nextLine();

        System.out.println("Achternaam: ");
        String achterNaam = scan.nextLine();

        System.out.println("Gender(Man, Vrouw of Non-Binair): ");
        System.out.println("1. Man");
        System.out.println("2. Vrouw");
        System.out.println("3. Non-Binair");
        String gender = null;
        int genderKeuze = scan.nextInt();
        if(genderKeuze == 1){
            gender = "Man";
        } else if (genderKeuze == 2) {
            gender = "Vrouw";
        } else if (genderKeuze == 3) {
            gender = "Non-Binair";
        }

        Land geboorteLand = setGeboorteLand();

        System.out.println("Leeftijd: ");
        int leeftijd = scan.nextInt();

        Dossier dossier = new Dossier();

        String gebruikersnaam = generateGebruikersnaam(voorNaam, achterNaam);
        String wachtwoord = generateWachtwoord(voorNaam);

        System.out.println();
        Vluchteling v =  new Vluchteling(voorNaam, achterNaam, gender, geboorteLand, leeftijd, dossier, gebruikersnaam, wachtwoord);
        vluchtelingen.add(v);

        gezinOnderdeel(v);

        DataSeeder.getInstance().getGebruikers().add(v);
        DataSeeder.getInstance().registerObservers();

        System.out.println("Aantal vluchtelingen in DataSeeder: " + seeder.getVluchtelingen().size());
    }

    private String generateGebruikersnaam(String voorNaam, String achterNaam) {
        return ("v_" + voorNaam + "_" + achterNaam).toLowerCase();
    }

    private String generateWachtwoord(String achterNaam) {
        Random rand = new Random();
        int randomNummer1 = rand.nextInt(10) + 1;
        int randomNummer2 = rand.nextInt(10) + 1;
        int randomNummer3 = rand.nextInt(10) + 1;
        int randomNummer4 = rand.nextInt(10) + 1;
        return achterNaam + randomNummer1 + randomNummer2 + randomNummer3 + randomNummer4;
    }

    public Land setGeboorteLand() {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        Land land = null;
        while (!check) {
            System.out.println("Geboorteland: ");
            String geboorteLandNaam = scan.nextLine();
            for (Land l : seeder.getVeiligeLanden()) {
                if (l.getName().equalsIgnoreCase(geboorteLandNaam)) {
                    check = true;
                    land = l;
                    break;
                }
            }
            if (!check) {
                System.out.println("Ongeldig geboorteland. Probeer opnieuw.");
            }
        }
        return land;
    }

    private Vluchteling getVluchteling(String naam) {
        for (Vluchteling v : vluchtelingen) {
            if (v.getVoorNaam().equalsIgnoreCase(naam) || v.getAchterNaam().equalsIgnoreCase(naam)) {
                return v;
            }
        }
        return null;
    }

    public void gezinOnderdeel(Vluchteling v){
        Scanner scan = new Scanner(System.in);
        Gezin gezin = null;
        System.out.println("Is de vluchteling onderdeel van een gezin? (ja/nee)");
        String isGezin = scan.nextLine();
        if (isGezin.equalsIgnoreCase("ja")) {
            System.out.println("Is de vluchteling het gezinshoofd? (ja/nee)");
            String isGezinshoofd = scan.nextLine();
            if (isGezinshoofd.equalsIgnoreCase("ja")) {
                gezin = new Gezin(v);
                v.setGezin(gezin);
            } else {
                System.out.println("Voer de naam van het gezinshoofd in:");
                String gezinshoofdNaam = scan.nextLine();
                Vluchteling gezinshoofd = getVluchteling(gezinshoofdNaam);
                if (gezinshoofd != null) {
                    gezin = gezinshoofd.getGezin();
                    if (gezin == null) {
                        gezin = new Gezin(gezinshoofd);
                        gezinshoofd.setGezin(gezin);
                    }
                    gezin.voegGezinslidToe(v);
                    v.setGezin(gezin);
                } else {
                    System.out.println("Gezinshoofd niet gevonden. De vluchteling wordt geregistreerd zonder gezin.");
                }
            }
        } else if (isGezin.equalsIgnoreCase("nee")) {
            System.out.println("De vluchteling wordt geregistreerd zonder gezin.");
        }
    }

    public static COA getInstance() {
        if(instance==null){
            instance = new COA();
        }
        return instance;
    }

    public void aanpassenVanDossier(Dossier dossier, String uitspraak, Vluchteling vluchteling){
        dossier.modifyUitspraak(uitspraak, dossier,vluchteling);
    }
    public void werkDossierBij(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoornaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchternaam = scan.nextLine();
        System.out.println();
        Vluchteling vluchteling = zoekVluchteling(vVoornaam, vAchternaam);

        if (vluchteling == null) {
            System.out.println("Vluchteling niet gevonden.");
            return;
        }

        Dossier vDossier = vluchteling.getDossier();
        if (vDossier == null) {
            System.out.println("Dossier van de vluchteling is niet gevonden.");
            return;
        }

        System.out.println("Wat moet er worden bij gewerkt in het dossier?");
        System.out.println("1. IND uitspraak");
        System.out.println("2. Plaasting van vluchteling in eigen woning starten");

        int keuze = scan.nextInt();

        if (keuze == 1){
            werkUitspraakDossierBij(vDossier, vluchteling);
        } else if (keuze == 2){
            werkPlaatsingDossierBij(vDossier);
        } else{
            System.out.println("Geef een geldige keuze mee.");
        }
    }

    public void werkUitspraakDossierBij(Dossier d, Vluchteling vluchteling){
        Scanner scan = new Scanner(System.in);
        System.out.println("Geef de nieuwe uitspraak van de IND: ");
        System.out.println("1. Geen");
        System.out.println("2. Verblijfsvergunning ");
        System.out.println("3. Aanvraag afgewezen");

        String vUitspraak = null;
        int keuze = scan.nextInt();
        if  (keuze == 1){
            vUitspraak = "Geen";
            d.modifyUitspraak(vUitspraak, d, vluchteling);
            System.out.println("Geen verblijfsvergunning verleent aan de vluchteling.");
        } else if (keuze == 2){
            vUitspraak = "Verblijfsvergunning";
            d.modifyUitspraak(vUitspraak, d, vluchteling);
            System.out.println("Verblijfsvergunning verleent aan de vluchteling.");
        } else if (keuze == 3){
            vUitspraak = "Aanvraag afgewezen";
            d.modifyUitspraak(vUitspraak, d, vluchteling);
            System.out.println("Aanvraag verblijfsvergunning afgewezen aan de vluchteling.");
        }
        aanpassenVanDossier(d, vUitspraak, vluchteling);
    }
    public void werkPlaatsingDossierBij(Dossier d){
        if(!d.getUitspraakIND().equalsIgnoreCase("Verblijfsvergunning")){
            System.out.println("Plaatsing kan niet gestart worden, omdat de vluchteling geen verblijfsvergunning heeft gekregen.");
            return;
        }
        d.plaatsingWoning(true);
    }

    public void plaatsingOfVeruizingVluchteling(){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Wat is de situatie van de vluchteling?: ");
        System.out.println("1. Vluchteling wordt geplaatst in AZC");
        System.out.println("2. Vluchteling verhuist uit AZC");
        int keuze = scan.nextInt();
        if (keuze == 1){
            plaatsingVluchteling();
        } else if (keuze == 2) {
            veruizingVluchteling();
        }
    }

    public void plaatsingVluchteling(){
        System.out.println("Vluchteling wordt geplaats");
        Scanner scan = new Scanner(System.in);
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoorNaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchterNaam = scan.nextLine();

        Vluchteling v = zoekVluchteling(vVoorNaam, vAchterNaam);
        if (v == null){
            System.out.println("Vluchteling niet geregistreerd.");
            return;
        }

        System.out.println();
        System.out.println("In welke gemeente wilt u de vluchteling plaatsen?");

        String gemeenteNaam = scan.nextLine();

        Gemeente g = DataSeeder.getGemeenteByNaam(gemeenteNaam);
        if (g == null){
            System.out.println("Geen gemeente gevonden.");
            return;
        }

        AZC azc = selecteerAZC(g);
        if (azc == null){
            System.out.println("Geen AZC gevonden.");
            return;
        }

        plaatsVluchtelingInAZC(v, azc);
        stuurBerichtNaarAZC(azc, v);
    }



    public void stuurBerichtNaarAZC(AZC azc, Vluchteling vluchteling){
        Bericht b = new Bericht(azc.getNaam(), vluchteling.getVoorNaam(), true);
        azc.krijgBericht(b);
    }

    private AZC selecteerAZC(Gemeente gemeente) {
        ArrayList<AZC> azcs = seeder.getAZCsInGemeente(gemeente);
        if (azcs.isEmpty()) {
            return null;
        }

        System.out.println("Selecteer een AZC in " + gemeente.getNaam() + ":");
        for (int i = 0; i < azcs.size(); i++) {
            System.out.println((i + 1) + ". " + azcs.get(i).getNaam());
        }

        Scanner scan = new Scanner(System.in);
        int keuze = scan.nextInt();
        scan.nextLine();

        if (keuze < 1 || keuze > azcs.size()) {
            System.out.println("Ongeldige keuze.");
            return null;
        }

        return azcs.get(keuze - 1);
    }
    public Vluchteling zoekVluchteling(String voorNaam, String achterNaam){
        for (Vluchteling v : vluchtelingen){
            if (v.getVoorNaam().equalsIgnoreCase(voorNaam) && v.getAchterNaam().equalsIgnoreCase(achterNaam)){
                return v;
            }
        }
        return null;
    }

    private void plaatsVluchtelingInAZC(Vluchteling vluchteling, AZC azc) {
        vluchteling.setAzc(azc);
        azc.voegVluchtelingToe(vluchteling);

        Gezin g = vluchteling.getGezin();
        if (g != null) {
            for (Vluchteling gezinslid : g.getGezinsleden()) {
                gezinslid.setAzc(azc);
                azc.voegVluchtelingToe(gezinslid);
            }
        }
    }

    private void verhuisVluchtelingNaarAZC(Vluchteling vluchteling, AZC huidigAZC, AZC nieuwAZC) {
        vluchteling.setAzc(nieuwAZC);
        huidigAZC.verwijderVluchteling(vluchteling);
        nieuwAZC.voegVluchtelingToe(vluchteling);

        Gezin g = vluchteling.getGezin();
        if (g != null) {
            for (Vluchteling gezinslid : g.getGezinsleden()) {
                gezinslid.setAzc(nieuwAZC);
                huidigAZC.verwijderVluchteling(gezinslid);
                nieuwAZC.voegVluchtelingToe(gezinslid);
            }
        }
    }

    public void veruizingVluchteling(){
        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scan = new Scanner(System.in);
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoorNaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchternaam = scan.nextLine();

        Vluchteling v = zoekVluchteling(vVoorNaam, vAchternaam);
        if (v == null) {
            System.out.println("Vluchteling niet geregistreerd.");
            return;
        }

        System.out.println("Geef de naam van het huidige AZC: ");
        String huidigAZCNaam = scan.nextLine();
        AZC huidigAZC = seeder.getAZCByName(huidigAZCNaam);
        if (huidigAZC == null) {
            System.out.println("Huidig AZC niet gevonden.");
            return;
        }
        System.out.println();

        System.out.println("In welke gemeente wilt u de vluchteling plaatsen?");
        String gemeenteNaam = scan.nextLine();

        Gemeente g = DataSeeder.getGemeenteByNaam(gemeenteNaam);
        if (g == null) {
            System.out.println("Geen gemeente gevonden.");
            return;
        }

        AZC nieuwAZC = selecteerAZC(g);
        if (nieuwAZC == null) {
            System.out.println("Geen nieuw AZC gevonden.");
            return;
        }

        verhuisVluchtelingNaarAZC(v, huidigAZC, nieuwAZC);
        stuurBerichtNaarAZC(nieuwAZC, v);

        System.out.println("Vluchteling " + vVoorNaam + " " + vAchternaam + " is succesvol verhuisd naar " + nieuwAZC.getNaam());
    }

    public void toonVluchtelingenLijst() {
        System.out.println("Lijst met vluchtelingen:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        DataSeeder.getInstance().showVluchtelingen();
    }

}
