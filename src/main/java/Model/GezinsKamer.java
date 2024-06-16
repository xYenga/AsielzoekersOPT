package Model;

public class GezinsKamer  extends Kamer{
    public GezinsKamer(int capaciteit, String gender, String veiligVoorLanders) {
        super(capaciteit, gender, veiligVoorLanders, "Gezin");
    }

    @Override
    Geschikt heeftGezin() {
        return new Geschikt(true);
    }

    @Override
    Geschikt isNBOfOuderen(int leeftijd) {
        return new Geschikt(false);
    }

    @Override
    Geschikt geschiktVoorGender(String gender) {return new Geschikt(getGender().equalsIgnoreCase(gender) || getGender().equalsIgnoreCase("Mixed"));}

    @Override
    Geschikt geschiktVoorJongerenOnder18(int leeftijd) {
        return new Geschikt(true);
    }

    @Override
    Geschikt geschiktVoorVeiligeLand() {return new Geschikt(true);}
}
