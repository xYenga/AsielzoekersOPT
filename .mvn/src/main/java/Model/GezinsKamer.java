package Model;

public class GezinsKamer  extends Kamer{
    public GezinsKamer(int capaciteit, String gender, String veiligVoorLanders, String type) {
        super(capaciteit, gender, veiligVoorLanders, type);
    }

    @Override
    boolean heeftGezin() {
        return true;
    }

    @Override
    boolean isNBOfOuderen() {
        return false;
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
        return true;
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
