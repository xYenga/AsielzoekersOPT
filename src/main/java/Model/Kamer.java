package Model;

public class Kamer {
    private int capaciteit;
    private String gender;
    private String veiligVoor;
    private String type;


    public Kamer(int capaciteit, String gender, String veiligVoor, String type) {
        this.capaciteit = capaciteit;
        this.gender = gender;
        this.veiligVoor = veiligVoor;
        this.type = type;
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

    public String getVeiligVoor() {
        return veiligVoor;
    }

    public void setVeiligVoor(String veiligVoor) {
        this.veiligVoor = veiligVoor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
