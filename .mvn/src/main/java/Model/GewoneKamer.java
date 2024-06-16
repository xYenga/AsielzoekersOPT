package Model;

public class GewoneKamer  extends Kamer{
    public GewoneKamer(int capaciteit, String gender, String veiligVoorLanders, String type) {
        super(capaciteit, gender, veiligVoorLanders, type);
    }

    @Override
    boolean heeftGezin() {
        return false;
    }

    @Override
    boolean isNBOfOuderen() {
        return getCapaciteit() == 1;
    }

    @Override
    boolean geschiktVoorGender(String gender) {
        return getGender().equals(gender);
    }

    @Override
    boolean geschiktVoorJongerenOnder18() {
        return false;
    }

    @Override
    boolean geschiktVoorVeiligeLand() {
        return getVeiligVoorLanders().equals("ja");
    }
//    @Override
//    boolean geschiktVoorVeiligeLand(Land land) {
//        if(land.isVeilig()){
//            return true;
//        } else {
//            return false;
//        }
//    }
}
