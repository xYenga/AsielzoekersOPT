package com.example.asielzoekersopt;

import Menu.Menu;
import Model.*;
import Security.DataSeeder;
import Security.LoginC;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args) {
//        GewoneKamer gewoneKamer = new GewoneKamer(2, "Man", "Veilig");
//        GewoneKamer gewoneKamer1 = new GewoneKamer(1, "Non-Binair", "Veilig");
//
//        System.out.println("Kamer Type: " + gewoneKamer.getType());
//        System.out.println("Capaciteit: " + gewoneKamer.getCapaciteit());
//        System.out.println("Gender: " + gewoneKamer.getGender());
//        System.out.println("Veilig Voor Landers: " + gewoneKamer.getVeiligVoorLanders());
//
//        // Maak een vluchteling aan
//        Land geboorteLand = new Land("VeiligLand", true);
//        Dossier dossier = new Dossier(false, "Geen", "Nee", false);
//        Vluchteling vluchteling = new Vluchteling("John", "Doe", "man", geboorteLand, 61, dossier, "johndoe", "password");
//        Vluchteling vluchteling1 = new Vluchteling("Johnny", "Doe11", "Non-Binair", geboorteLand, 55, dossier, "johndoe", "password");
//
//        // Controleer of de vluchteling aan de kamer kan worden toegewezen
//
//        if (gewoneKamer.toewijzingRegel(vluchteling)) {
//            gewoneKamer.voegVluchtelingToe(vluchteling);
//            System.out.println("Vluchteling " + vluchteling.getVoorNaam() + " " + vluchteling.getAchterNaam() + " is toegewezen aan de gewone kamer.");
//        } else {
//            System.out.println("Geen geschikte kamer beschikbaar voor " + vluchteling.getVoorNaam() + " " + vluchteling.getAchterNaam());
//        }
//
//        if (gewoneKamer1.toewijzingRegel(vluchteling1)) {
//            gewoneKamer1.voegVluchtelingToe(vluchteling1);
//            System.out.println("Vluchteling " + vluchteling1.getVoorNaam() + " " + vluchteling1.getAchterNaam() + " is toegewezen aan de gewone kamer.");
//        } else {
//            System.out.println("Geen geschikte kamer beschikbaar voor " + vluchteling1.getVoorNaam() + " " + vluchteling1.getAchterNaam());
//        }
//
//    }


        DataSeeder seeder = DataSeeder.getInstance();

        while (true) {
            Menu menu = seeder.getMenu();
            menu.toonMenu();
        }
    }




//        Scanner scan = new Scanner(System.in);
//        System.out.println("Welkom bij de AZC!");
//        System.out.println("U kunt hieronder inloggen om te beginnen.");
//        System.out.println();
//        System.out.print("Gebruikersnaam: ");
//        String gebruikersnaam = scan.nextLine();
//        System.out.print("    Wachtwoord: ");
//        String wachtwoord = scan.nextLine();
//        System.out.println(gebruikersnaam + " " +wachtwoord);

//        Dossier dossier = new Dossier();
//
//        // Maak een nieuw Gezin-object aan
//        Gezin gezin = new Gezin();
//
//        // Maak een nieuw Land-object aan voor het geboorteland van de vluchteling
//        Land geboorteLand = new Land("Syrië", false);
//
//        // Maak een nieuw Vluchteling-object aan met de gegeven parameters
//        Vluchteling vluchteling = new Vluchteling("John Doe", "Man", geboorteLand, 30, dossier, gezin, null);
//
//
//        // Roep de statusDossier()-methode aan om de status van het dossier van de vluchteling te tonen
//        vluchteling.statusDossier();
//
//        // Wijzig de status van het dossier
//        dossier.setAsielAanvraagCompleet(true);
//        dossier.modifyUitspraak("Verblijfsvergunning verleend");
//        dossier.setPlaatsWoning("Ja");
//        dossier.setTeruggekeerd(true);
//        System.out.println(dossier.isTeruggekeerd());
//
//        System.out.println(vluchteling.getNaam());
//        // Roep de statusDossier()-methode opnieuw aan om de bijgewerkte status van het dossier te tonen
//        System.out.println("\nNa het bijwerken van het dossier:");
//        vluchteling.statusDossier();

//        DataSeederLandAndGemeente LGseeder = new DataSeederLandAndGemeente();
//        LGseeder.Gemeente();

//        DataSeeder seeder = new DataSeeder();
//        seeder.initialize();
//
//        Gemeente g = new Gemeente();
//

}

