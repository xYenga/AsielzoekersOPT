package Security;

import java.util.List;

public class COAMedewerker extends Gebruiker {
    public COAMedewerker(String gebruikersnaam, String wachtwoord, String rol, List<String> rechten) {
        super(gebruikersnaam, wachtwoord, rol, rechten);
    }

    @Override
    public void inloggen() {

    }
}
