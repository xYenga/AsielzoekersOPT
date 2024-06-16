package Model;

public class Bericht {
    private String naamAZC;
    private String naamVluchteling;
    private boolean isRelevant;
    private String inhoud;
    private String type;

    public Bericht(String naamAZC, String naamVluchteling, boolean isRelevant) {
        this.naamAZC = naamAZC;
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
    }

    public Bericht(String naamVluchteling, boolean isRelevant, String inhoud, String type) {
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
        this.inhoud = inhoud;
        this.type = type;
    }

    public Bericht(String naamVluchteling, boolean isRelevant, String type) {
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
        this.type = type;
    }

    public Bericht(String naamAZC, String naamVluchteling, boolean isRelevant, String inhoud) {
        this.naamAZC = naamAZC;
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
        this.inhoud = inhoud;
    }

    public Bericht(String naamAZC, String naamVluchteling, boolean isRelevant, String inhoud, String type) {
        this.naamAZC = naamAZC;
        this.naamVluchteling = naamVluchteling;
        this.isRelevant = isRelevant;
        this.inhoud = inhoud;
        this.type = type;
    }

    public String showBericht(Bericht b){
        return "Titel: " + b.inhoud;
    }


    //getters & setters
    public String getNaamAZC() {
        return naamAZC;
    }

    public String getNaamVluchteling() {
        return naamVluchteling;
    }

    public void setRelevant(boolean relevant) {
        isRelevant = relevant;
    }

    public boolean isRelevant() {
        return isRelevant;
    }

    public String getType() {
        return this.type;
    }
}
