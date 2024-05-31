package Security;

import java.util.List;

public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam, String wachtwoord, List<String> rechten) {
        super(gebruikersnaam, wachtwoord, "Beheerder", rechten);
    }

    @Override
    public void inloggen() {

    }
}
