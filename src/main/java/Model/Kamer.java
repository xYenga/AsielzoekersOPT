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

    abstract Geschikt heeftGezin();
    abstract Geschikt isNBOfOuderen(int leeftijd);
    abstract Geschikt geschiktVoorGender(String gender);
    abstract Geschikt geschiktVoorJongerenOnder18(int leeftijd);
    abstract Geschikt geschiktVoorVeiligeLand();

    public final boolean toewijzingRegel(Vluchteling v) {
        Geschikt gezinGeschikt = heeftGezin();
        Geschikt nbOfOuderenGeschikt = isNBOfOuderen(v.getLeeftijd());
        Geschikt genderGeschikt = geschiktVoorGender(v.getGender());
        Geschikt jongerenGeschikt = geschiktVoorJongerenOnder18(v.getLeeftijd());
        Geschikt veiligLandGeschikt = geschiktVoorVeiligeLand();
            if (this instanceof GewoneKamer) {
                return (nbOfOuderenGeschikt.isGeschikt()) &&
                        genderGeschikt.isGeschikt() && veiligLandGeschikt.isGeschikt();
            } else if (this instanceof JongerenKamer) {
                return genderGeschikt.isGeschikt() &&
                        jongerenGeschikt.isGeschikt() && veiligLandGeschikt.isGeschikt();
            } else if (this instanceof GezinsKamer) {
                if(v.getGezin() != null) {
                    return gezinGeschikt.isGeschikt() && genderGeschikt.isGeschikt();
                } else return false;
            }
        return false;
    }

    public void voegVluchtelingToe(Vluchteling vluchteling, Kamer kamer) {
        verhoogAantalVluchtelingen();
        System.out.println("Vluchteling " + vluchteling.getVoorNaam() + " geplaatst in de volgende kamer:");
        showKamer(kamer);
        if (vluchteling.getGezin() != null){
            if (/*!DataSeeder.getInstance().getVluchtelingByNaam(vluchteling.getVoorNaam(), vluchteling.getAchterNaam())*/!vluchteling.getGezin().getGezinsleden().isEmpty()) {
                System.out.println("wow");
                for (int i = 0; i < vluchteling.getGezin().getGezinsleden().size(); i++) {
                    verhoogAantalVluchtelingen();
                }
            }
        }
    }
    public void showKamer(Kamer kamer){
        System.out.println("Type kamer: " + kamer.type);
        System.out.println("Capaciteit kamer: " + kamer.capaciteit);
        System.out.println("Gender kamer: " + kamer.gender);
        System.out.println("Veilig landers kamer: " + kamer.veiligVoorLanders);
        System.out.println("Aantal vluchtelingen in de kamer: " + kamer.aantalVluchtelingenGevestigd);
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
