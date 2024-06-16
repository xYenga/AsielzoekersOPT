package Model;

public class JongerenKamer extends Kamer{
    public JongerenKamer(int capaciteit, String gender, String veiligVoorLanders, String type) {
        super(capaciteit, gender, veiligVoorLanders, type);
    }

    @Override
    boolean heeftGezin() {
        return false;
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
        return true;
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
