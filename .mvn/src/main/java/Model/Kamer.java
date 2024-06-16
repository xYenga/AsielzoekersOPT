package Model;

import Security.DataSeeder;

import java.util.ArrayList;

public abstract class Kamer {
    private int capaciteit;
    private String gender;
    private String veiligVoorLanders;
    private String type;
    private int aantalVluchtelingenGevestigd;
    private ArrayList<Vluchteling> vluchtelingen;
    DataSeeder seeder = DataSeeder.getInstance();

//    public Kamer(){
//        this.vluchtelingen = seeder.getVluchtelingen();
//    }

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

    public Kamer(int capaciteit, String gender, String veiligVoorLanders, String type) {
        this.capaciteit = capaciteit;
        this.gender = gender;
        this.veiligVoorLanders = veiligVoorLanders;
        this.type = type;
        this.aantalVluchtelingenGevestigd = 0;
        this.vluchtelingen = new ArrayList<>();
    }

    abstract boolean heeftGezin();
    abstract boolean isNBOfOuderen();
    abstract boolean geschiktVoorGender(String gender);
    abstract boolean geschiktVoorJongerenOnder18();
    abstract boolean geschiktVoorVeiligeLand();
    //abstract boolean geschiktVoorVeiligeLand(Land land);

    public final boolean toewijzingRegel(Vluchteling v){
        return heeftGezin() && isNBOfOuderen() && geschiktVoorGender(v.getGender())
                && geschiktVoorJongerenOnder18() && geschiktVoorVeiligeLand();
    }

    public void voegVluchtelingToe(Vluchteling vluchteling) {
        verhoogAantalVluchtelingen();
        if (!vluchteling.getGezin().getGezinsleden().isEmpty()) {
            for (int i = 0; i < vluchteling.getGezin().getGezinsleden().size(); i++) {
                verhoogAantalVluchtelingen();
            }
        }
    }

    public boolean verwijderVluchteling(Vluchteling vluchteling) {
        if (getAantalVluchtelingenGevestigd() > 0) {
            verlaagAantalVluchtelingen();
            if (!vluchteling.getGezin().getGezinsleden().isEmpty()) {
                for (int i = 0; i < vluchteling.getGezin().getGezinsleden().size(); i++) {
                    verlaagAantalVluchtelingen();
                }
            }
            return true;
        }
        return false;
    }

    public ArrayList<Vluchteling> getVluchtelingen() {
        return vluchtelingen;
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
