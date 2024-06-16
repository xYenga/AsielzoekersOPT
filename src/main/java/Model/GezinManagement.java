package Model;

import java.util.Scanner;

public class GezinManagement {
    private static GezinManagement instance = null;

    public static GezinManagement getInstance() {
        if(instance==null){
            instance = new GezinManagement();
        }
        return instance;
    }

    public void gezinOnderdeel(Vluchteling v){
        Scanner scan = new Scanner(System.in);
        Gezin gezin;
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
                Vluchteling gezinshoofd = COA.getInstance().zoekVluchteling(gezinshoofdNaam, v.getAchterNaam());
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
}
