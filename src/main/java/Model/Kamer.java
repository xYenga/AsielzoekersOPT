package Model;

public class Kamer {
    private int capaciteit;
    private String gender;
    private String veiligVoorLanders;
    private String type;
    private int aantalVluchtelingenGevestigd;


    public Kamer(int capaciteit, String gender, String veiligVoorLanders, String type) {
        this.capaciteit = capaciteit;
        this.gender = gender;
        this.veiligVoorLanders = veiligVoorLanders;
        this.type = type;
        this.aantalVluchtelingenGevestigd = 0;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVeiligVoorLanders() {
        return veiligVoorLanders;
    }

    public void setVeiligVoorLanders(String veiligVoor) {
        this.veiligVoorLanders = veiligVoor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAantalVluchtelingenGevestigd() {return aantalVluchtelingenGevestigd;}

    public void verhoogAantalVluchtelingen() {
        if (aantalVluchtelingenGevestigd < capaciteit) {
            aantalVluchtelingenGevestigd++;
        }
    }
    public void verlaagAantalVluchtelingen() {
        if (aantalVluchtelingenGevestigd > 0) {
            aantalVluchtelingenGevestigd--;
        }
    }

}
