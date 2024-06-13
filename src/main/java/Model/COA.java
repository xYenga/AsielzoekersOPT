package Model;

import Security.DataSeeder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class COA {
    DataSeeder seeder = DataSeeder.getInstance();
    private static COA instance = null;
    private ArrayList<Vluchteling> vluchtelingen = new ArrayList<>();
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
        System.out.println("Is de vluchteling onderdeel van een gezin? (ja/nee)");

        gezinOnderdeel(v);
    }

//    public void showList(){
//        for (Vluchteling v : vluchtelingen){
//            System.out.println(v.getVoorNaam());
//            System.out.println(v.getAchterNaam());
//            System.out.println(v.getAdres());
//            System.out.println(v.getGender());
//            System.out.println(v.getLeeftijd());
//            System.out.println(v.getGeboorteLand());
//
//        }
//    }
    private String generateGebruikersnaam(String voorNaam, String achterNaam) {
        String gebruikersnaam = ("v_" + voorNaam + "_" + achterNaam).toLowerCase();
        return gebruikersnaam;
    }

    private String generateWachtwoord(String achterNaam) {
        Random rand = new Random();
        int randomNummer1 = rand.nextInt(10) + 1;
        int randomNummer2 = rand.nextInt(10) + 1;
        int randomNummer3 = rand.nextInt(10) + 1;
        int randomNummer4 = rand.nextInt(10) + 1;

        String wachtwoord = achterNaam + randomNummer1 + randomNummer2 + randomNummer3 + randomNummer4 ;
        return wachtwoord;
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
        String isGezin = scan.nextLine();
        Gezin gezin = null;
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
        }
    }
    public static COA getInstance() {
        if(instance==null){
            instance = new COA();
        }
        return instance;
    }

    public void aanpassenVanDossier(Dossier dossier, String uitspraak){
        dossier.modifyUitspraak(uitspraak);
        dossier.plaatsingWoning(uitspraak);
    }
    public void werkDossierBij(){
        Vluchteling vluchteling = new Vluchteling();
        Dossier vDossier = vluchteling.getDossier();
        String vUitspraak = vDossier.getUitspraakIND();
        aanpassenVanDossier(vDossier, vUitspraak);
    }


    public void vertrekNaarLandVanHerkomst(){}
}
