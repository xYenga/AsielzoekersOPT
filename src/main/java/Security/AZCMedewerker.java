package Security;

import Menu.Menu;

public class AZCMedewerker extends Gebruiker{

    public AZCMedewerker(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "AZCMedewerker");
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getAZCMedewerkerMenu();
    }
}
