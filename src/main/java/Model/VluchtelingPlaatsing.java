package Model;

import Security.DataSeeder;

import java.util.ArrayList;
import java.util.Scanner;

public class VluchtelingPlaatsing {
    DataSeeder seeder = DataSeeder.getInstance();
    Scanner scan = new Scanner(System.in);
    public void plaatsingOfVeruizingVluchteling(){
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
        scan.nextLine();
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoorNaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchterNaam = scan.nextLine();

        Vluchteling v = DataSeeder.getInstance().getVluchtelingByNaam(vVoorNaam, vAchterNaam);
        System.out.println(v.getVoorNaam());
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
        Vluchteling.getInstance().maakBericht("Plaatsing", azc.getNaam(), v.getVoorNaam(),v.getAchterNaam());
        DataSeeder.getInstance().voegBerichtToe(Vluchteling.getInstance().maakBericht("Plaatsing", azc.getNaam(), v.getVoorNaam(),v.getAchterNaam()));
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

        int keuze = scan.nextInt();
        scan.nextLine();

        if (keuze < 1 || keuze > azcs.size()) {
            System.out.println("Ongeldige keuze.");
            return null;
        }

        return azcs.get(keuze - 1);
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
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoorNaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchternaam = scan.nextLine();

        Vluchteling v = COA.getInstance().zoekVluchteling(vVoorNaam, vAchternaam);

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
        Vluchteling.getInstance().maakBericht("Verhuizing", nieuwAZC.getNaam(), v.getVoorNaam(),v.getAchterNaam());
        DataSeeder.getInstance().voegBerichtToe(Vluchteling.getInstance().maakBericht("Verhuizing", nieuwAZC.getNaam(), v.getVoorNaam(),v.getAchterNaam()));


        System.out.println("Vluchteling " + vVoorNaam + " " + vAchternaam + " is succesvol verhuisd naar " + nieuwAZC.getNaam());
    }
}
