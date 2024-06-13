package Security;

import Menu.Menu;
import Model.Dossier;
import Model.IVluchteling;

public class Vluchteling extends Gebruiker implements IVluchteling {

    public Vluchteling(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "Vluchteling");
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }

    @Override
    public void statusDossier() {}
}
