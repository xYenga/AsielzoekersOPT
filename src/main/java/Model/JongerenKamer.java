package Model;

public class JongerenKamer extends Kamer{
    public JongerenKamer(int capaciteit, String gender, String veiligVoorLanders) {
        super(capaciteit, gender, veiligVoorLanders, "Jongeren");
    }

    @Override
    Geschikt heeftGezin() {
        return new Geschikt(false);
    }

    @Override
    Geschikt isNBOfOuderen(int leeftijd) {
        return new Geschikt(false);
    }

    @Override
    Geschikt geschiktVoorGender(String gender) {
        return new Geschikt(getGender().equalsIgnoreCase(gender));
    }
    @Override
    Geschikt geschiktVoorJongerenOnder18(int leeftijd) {
        return new Geschikt(leeftijd < 18);
    }

    @Override
    Geschikt geschiktVoorVeiligeLand() {
        return new Geschikt(getVeiligVoorLanders().equalsIgnoreCase("veilig") || getVeiligVoorLanders().equalsIgnoreCase("onveilig"));
    }
}
