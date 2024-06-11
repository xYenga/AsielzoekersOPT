package Model;

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

    //methods
    public void modifyUitspraak(String uitspraakIND){
        if(this.asielAanvraagCompleet){
            this.uitspraakIND = uitspraakIND;
        }
    }

    public void plaatsingWoning(String uitspraakIND){
        if(this.uitspraakIND.equals("Vergunning")){
            this.plaatsWoning = "Gestart";
        } else {
            System.out.println();
        }
    }

    public void nieuwDossier(){
        this.asielAanvraagCompleet = false;
        this.uitspraakIND = "geen";
        this.plaatsWoning = "nee";
        this.teruggekeerd = false;
    }

    //getters & setters
    public String getPlaatsWoning() {
        return plaatsWoning;
    }

    public void setPlaatsWoning(String plaatsWoning) {
        this.plaatsWoning = plaatsWoning;
    }

    public String getUitspraakIND() {
        return uitspraakIND;
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
