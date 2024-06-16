package Model;

import Security.DataSeeder;

import java.util.Scanner;

public class VluchtelingDossier {

    Scanner scan = new Scanner(System.in);
    private Dossier dossier;
    VluchtelingDossier(Dossier dossier){
        this.dossier = dossier;
    }
    VluchtelingDossier(){}

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public void printStatusDossier(){
        System.out.println("Status van Dossier van vluchteling");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Asielaanvraag is afgerond: " + (dossier.isAsielAanvraagCompleet() ? "Ja" : "Nee"));
        System.out.println("Uitspraak IND: " + dossier.getUitspraakIND());
        System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsWoning());
        System.out.println("Teruggekeerd naar het land van herkomst: " + (dossier.isTeruggekeerd() ? "Ja" : "Nee"));
    }

    public void werkDossierBij(){
        scan.nextLine();
        System.out.println("Geef de voornaam van de vluchteling: ");
        String vVoornaam = scan.nextLine();
        System.out.println("Geef de achternaam van de vluchteling: ");
        String vAchternaam = scan.nextLine();
        System.out.println();
        Vluchteling vluchteling = DataSeeder.getInstance().getVluchtelingByNaam(vVoornaam, vAchternaam);

        if (vluchteling == null) {
            System.out.println("Vluchteling niet gevonden.");
            return;
        }

        Dossier vDossier = vluchteling.getDossier();
        if (vDossier == null) {
            System.out.println("Dossier van de vluchteling is niet gevonden.");
            return;
        }
        System.out.println();
        System.out.println();
        System.out.println("Wat moet er worden bij gewerkt in het dossier?");
        System.out.println("1. IND uitspraak");
        System.out.println("2. Plaasting van vluchteling in eigen woning starten");

        int keuze = scan.nextInt();

        if (keuze == 1){
            werkUitspraakDossierBij(vDossier, vluchteling);
        } else if (keuze == 2){
            werkPlaatsingDossierBij(vDossier, vluchteling);
        } else{
            System.out.println("Geef een geldige keuze mee.");
        }
    }
    public void aanpassenVanDossier(Dossier dossier, String uitspraak, Vluchteling vluchteling){
        dossier.modifyUitspraak(uitspraak);
        DataSeeder.getInstance().updateVluchteling(vluchteling);
    }

    public void werkUitspraakDossierBij(Dossier d, Vluchteling vluchteling){
        System.out.println("Geef de nieuwe uitspraak van de IND: ");
        System.out.println("1. Geen");
        System.out.println("2. Verblijfsvergunning ");
        System.out.println("3. Aanvraag afgewezen");

        String vUitspraak = null;
        int keuze = scan.nextInt();
        if  (keuze == 1){
            vUitspraak = "Geen";
            System.out.println("Geen verblijfsvergunning verleent aan de vluchteling.");
        } else if (keuze == 2){
            vUitspraak = "Verblijfsvergunning";
            d.setAsielAanvraagCompleet(true);
            System.out.println("Verblijfsvergunning verleent aan de vluchteling.");
        } else if (keuze == 3){
            vUitspraak = "Aanvraag afgewezen";
            d.setAsielAanvraagCompleet(true);
            System.out.println("Aanvraag verblijfsvergunning afgewezen aan de vluchteling.");
        }

        if (!d.isAsielAanvraagCompleet()){
            System.out.println("Asielaanvraag is nog lopend. Bijwerken van IND uitspraak afgewezen");
            return;
        }

        aanpassenVanDossier(d, vUitspraak, vluchteling);
    }
    public void werkPlaatsingDossierBij(Dossier d, Vluchteling vluchteling){
        if(!d.getUitspraakIND().equalsIgnoreCase("Verblijfsvergunning")){
            System.out.println("Plaatsing kan niet gestart worden, omdat de vluchteling geen verblijfsvergunning heeft gekregen.");
            return;
        }
        d.plaatsingWoning(true);
        DataSeeder.getInstance().updateVluchteling(vluchteling);
    }
}
