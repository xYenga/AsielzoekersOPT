package Model;

public class GewoneKamer extends Kamer{
    public GewoneKamer(int capaciteit, String gender, String veiligVoorLanders) {
        super(capaciteit, gender, veiligVoorLanders, "Gewone");
    }

    @Override
    Geschikt heeftGezin() {
        return new Geschikt(false);
    }

    @Override
    Geschikt isNBOfOuderen(int leeftijd) {
        if (getCapaciteit() == 1){
            return new Geschikt(getGender().equalsIgnoreCase("Non-Binair") || leeftijd >= 60);
        }else {
            return new Geschikt(!getGender().equalsIgnoreCase("Non-Binair") && leeftijd < 60);
        }
    }

    @Override
    Geschikt geschiktVoorGender(String gender) {
        return new Geschikt(getGender().equalsIgnoreCase(gender) || "Mixed".equalsIgnoreCase(getGender()));
    }

    @Override
    Geschikt geschiktVoorJongerenOnder18(int leeftijd) {
        if(leeftijd < 18){
            return new Geschikt(false);
        }
        return new Geschikt(true);
    }

    @Override
    Geschikt geschiktVoorVeiligeLand() {
        return new Geschikt(getVeiligVoorLanders().equalsIgnoreCase("veilig") || getVeiligVoorLanders().equalsIgnoreCase("onveilig"));
    }
}
