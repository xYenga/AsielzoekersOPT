package Security;

import Menu.Menu;


public class COAMedewerker extends Gebruiker {

    public COAMedewerker(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "COAMedewerker");
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getCOAMedewerkerMenu();
    }
}
