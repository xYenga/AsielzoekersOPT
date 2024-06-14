package Security;

import Menu.Menu;
import Model.AZC;

public class AZCMedewerker extends Gebruiker{

    private AZC azc;

    public AZC getAzc() {
        return azc;
    }

    public void setAzc(AZC azc) {
        this.azc = azc;
    }

    public AZCMedewerker(String gebruikersnaam, String wachtwoord) {
        super(gebruikersnaam, wachtwoord, "AZCMedewerker");
    }

    @Override
    public Menu inloggen() {
        return DataSeeder.getInstance().getAZCMedewerkerMenu();
    }
}
