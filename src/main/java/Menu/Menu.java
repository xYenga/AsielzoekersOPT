package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String titel;
    private ArrayList<Menukeuze> menukeuzes;
    private int laatsteMenukeuze;

    private void setTitel (String titel) {
        this.titel = titel;
    }

    private void setLaatsteMenukeuze (int laatsteMenukeuze) {
        this.laatsteMenukeuze = laatsteMenukeuze;
    }

    private void resetLaatsteMenukeuze () {
        setLaatsteMenukeuze (-1);
    }

    public void resetMenukeuzes () {
        menukeuzes = new ArrayList <> ();
        resetLaatsteMenukeuze ();
    }

    public int getLaatsteMenukeuze () {
        return this.laatsteMenukeuze;
    }

    public Menu (String titel) {
        setTitel (titel);
        resetMenukeuzes ();
        resetLaatsteMenukeuze ();
    }

    public void voegMenukeuzeToe (Menukeuze keuze) {
        menukeuzes.add (keuze);
        keuze.setKeuze (menukeuzes.size ());
    }

    public Menukeuze getJuisteMenukeuze (int keuze) {

        for (Menukeuze menukeuze : menukeuzes) {

            if (menukeuze.getKeuze () == keuze) {
                return menukeuze;
            }
        }

        return null;
    }

    public void toonMenu () {

        Scanner scanner = new Scanner (System.in);

        System.out.println();
        System.out.printf("=== %s%n", this.titel);

        for (Menukeuze menukeuze : menukeuzes) {
            menukeuze.toon();
        }

        System.out.println ();
        System.out.print ("Wat wilt u doen? Maak een keuze: ");
        setLaatsteMenukeuze (scanner.nextInt ()); scanner.nextLine ();
        Menukeuze menukeuze = getJuisteMenukeuze (getLaatsteMenukeuze ());

        if (menukeuze != null) {
            menukeuze.voerActieUit();
        }
        else {
            System.out.println ("Deze menukeuze bestaat niet. Kies opnieuw.");
        }
    }
}