package Model;

import Security.DataSeeder;
import Security.LoginC;

import java.security.PublicKey;
import java.util.ArrayList;

public class Beheerder{
    DataSeeder seeder = DataSeeder.getInstance();
    private static Beheerder instance = null;
    private ArrayList<AZC> azcs;
    private ArrayList<Gemeente> gemeentes;

    public Beheerder(){
        gemeentes = seeder.getGemeenten();
        azcs = seeder.getAZCs();
    }

    public void toonAZCs(Gemeente gemeente){
        System.out.println("Alle AZC's in de gemeente " + gemeente.getNaam());
        for (AZC azc : gemeente.getAzcs()){
            System.out.println(" - " + azc.getNaam());
        }
    }
    public void toonGemeentes(){
        for (Gemeente g : gemeentes){
            System.out.println("Naam van Gemeente: " + g.getNaam() + " - Aantal Inwoners: " + g.getAantalInwoners());
            toonAZCs(g);
            System.out.println();
        }
    }
    public static Beheerder getInstance() {
        if(instance==null){
            instance = new Beheerder();
        }
        return instance;
    }
}
