package Security;

import java.util.List;

public class AZCMedewerker extends Gebruiker{

    public AZCMedewerker(String gebruikersnaam, String wachtwoord, List<String> rechten) {
        super(gebruikersnaam, wachtwoord, "AZCMedewerker", rechten);
    }

    //    @Override
    public void inloggen() {

    }
}
