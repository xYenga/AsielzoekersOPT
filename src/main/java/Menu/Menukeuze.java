package Menu;

public class Menukeuze implements IActie{
    private int keuze;
    private String titel;
    boolean extraLegeRegel;
    IActie actie;

    public void setKeuze(int keuze){
        if((keuze == -1) || (this.keuze == -1)){
            this.keuze = keuze;
        }
    }

    public int getKeuze() {
        return this.keuze;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setExtraLegeRegel(boolean extraLegeRegel) {
        this.extraLegeRegel = extraLegeRegel;
    }

    public void setActie(IActie actie) {
        this.actie = actie;
    }

    public Menukeuze(int keuze, String titel, boolean extraLegeRegel, IActie actie){
        setKeuze(-1);
        setKeuze(keuze);
        setTitel(titel);
        setExtraLegeRegel(extraLegeRegel);
        setActie(actie);
    }

    public Menukeuze (String titel, IActie actie){
        this (-1, titel, false, actie);
    }
    public Menukeuze (int keuze, String titel, IActie actie){
        this (keuze, titel, false, actie);
    }

    public void toon (){
        System.out.printf("%2d. %s%n", this.keuze, this.titel);
    }

    @Override
    public void voerActieUit(){
        if (actie != null){
            actie.voerActieUit();
        } else {
            System.out.println("Er zijn geen actie gedefinieerd voor deze menukeuze");
        }
    }

}
