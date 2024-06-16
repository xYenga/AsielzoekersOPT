package Model;

import Security.DataSeeder;
import Security.LoginC;

public class Dossier {
    boolean asielAanvraagCompleet;
    String uitspraakIND;
    String plaatsWoning;
    boolean teruggekeerd;

    public Dossier(){
        this.asielAanvraagCompleet = false;
        this.uitspraakIND = "geen";
        this.plaatsWoning = "nee";
        this.teruggekeerd = false;
    }

    public Dossier(boolean asielAanvraagCompleet, String uitspraakIND, String plaatsWoning, boolean teruggekeerd) {
    }

    //methods
    public void modifyUitspraak(String uitspraakIND /*Dossier d, Vluchteling v*/){
            this.uitspraakIND=uitspraakIND;
            if(!uitspraakIND.equals("Geen")) {
                this.asielAanvraagCompleet = true;
            }
            //nieuwDossier(d.isAsielAanvraagCompleet(),this.uitspraakIND = uitspraakIND, getPlaatsWoning(),d.isTeruggekeerd(), v.getVoorNaam(), v.getAchterNaam());
    }

    public void plaatsingWoning(boolean check){
        if(check){
            this.plaatsWoning = "Gestart";
            System.out.println("Plaatsing voor de vluchteling is gestart.");
        } else{
            this.plaatsWoning = "Nee";
        }
    }


    public void nieuwDossier(boolean asielAanvraagCompleet, String uitspraakIND, String plaatsWoning, boolean teruggekeerd){
        this.asielAanvraagCompleet = asielAanvraagCompleet;
        this.uitspraakIND = uitspraakIND;
        this.plaatsWoning = plaatsWoning;
        this.teruggekeerd = teruggekeerd;
    }



    public String getPlaatsWoning() {
        return plaatsWoning;
    }

    public void setPlaatsWoning(String plaatsWoning) {
        this.plaatsWoning = plaatsWoning;
    }

    public String getUitspraakIND() {
        return uitspraakIND;
    }

    public void setUitspraakIND(String uitspraakIND) {
        this.uitspraakIND = uitspraakIND;
    }

    public boolean isAsielAanvraagCompleet() {
        return asielAanvraagCompleet;
    }

    public void setAsielAanvraagCompleet(boolean asielAanvraagCompleet) {
        this.asielAanvraagCompleet = asielAanvraagCompleet;
    }

    public boolean isTeruggekeerd() {
        return teruggekeerd;
    }

    public void setTeruggekeerd(boolean teruggekeerd) {
        this.teruggekeerd = teruggekeerd;
    }
}
