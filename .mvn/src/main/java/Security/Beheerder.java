package Security;

import Menu.Menu;


public class Beheerder extends Gebruiker {

    public Beheerder(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "Beheerder");
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}
