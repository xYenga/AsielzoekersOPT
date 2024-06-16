package Model;

import Security.DataSeeder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VluchtelingRegistratie {
    Scanner scan = new Scanner(System.in);
    DataSeeder seeder = DataSeeder.getInstance();
    private ArrayList<Vluchteling> vluchtelingen;

    private GezinManagement gM;
    public VluchtelingRegistratie(){
        vluchtelingen = seeder.getVluchtelingen();
    }

    public void registreerVluchteling(){
        scan.nextLine();
        System.out.println("Vul de gegevens van de Vluchteling in: ");

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
        System.out.println("Gebruikersnaam voor nieuwe vluchteling: " + gebruikersnaam);
        System.out.println("Wachtwoord voor nieuwe vluchteling: " + wachtwoord);
        System.out.println();
        Vluchteling v =  new Vluchteling(voorNaam, achterNaam, gender, geboorteLand, leeftijd, dossier, gebruikersnaam, wachtwoord);
        vluchtelingen.add(v);

        GezinManagement.getInstance().gezinOnderdeel(v);

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
        boolean check = false;
        Land land = null;
        while (!check) {
            System.out.println("Geboorteland: ");
            scan.nextLine();
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
}
