package Model;

import Security.DataSeeder;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class COA {

    private static COA instance = null;
    private ArrayList<Vluchteling> vluchtelingen;
    private VluchtelingRegistratie vR;
    private VluchtelingDossier vD;
    private GezinManagement gM;
    private VluchtelingPlaatsing vP;


    public COA(){
        DataSeeder seeder = DataSeeder.getInstance();
        vluchtelingen = seeder.getVluchtelingen();
        vR = new VluchtelingRegistratie();
        vD = new VluchtelingDossier();
        gM = new GezinManagement();
        vP = new VluchtelingPlaatsing();
    }

    public void registreerVluchteling(){
        vR.registreerVluchteling();
    }

    public void werkDossierBij(){
        vD.werkDossierBij();
    }

    public void plaatsingOfVerhuizingVluchteling(){
        vP.plaatsingOfVeruizingVluchteling();
    }

    public static COA getInstance() {
        if(instance==null){
            instance = new COA();
        }
        return instance;
    }

    public Vluchteling zoekVluchteling(String voorNaam, String achterNaam){
        for (Vluchteling v : vluchtelingen){
            if (v.getVoorNaam().equalsIgnoreCase(voorNaam) && v.getAchterNaam().equalsIgnoreCase(achterNaam)){
                return v;
            }
        }
        return null;
    }

    public void toonVluchtelingenLijst() {
        System.out.println("Lijst met vluchtelingen:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        DataSeeder.getInstance().showVluchtelingen();
    }

}
