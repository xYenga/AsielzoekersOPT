package com.example.asielzoekersopt;

import Menu.Menu;
import Model.Gemeente;
import Security.DataSeeder;

public class Main {
    public static void main(String[]args){
        DataSeeder seeder = DataSeeder.getInstance();

        while (true){
            Menu menu = seeder.getMenu();
            menu.toonMenu();
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
}
