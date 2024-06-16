package Menu;

import Model.AZC;
import Security.AZCMedewerker;
import Security.DataSeeder;
import Security.Gebruiker;
import Security.LoginC;

public class ActieToonBerichtenbox implements IActie{
    @Override
    public void voerActieUit() {
        LoginC lc = LoginC.getInstance();
        Gebruiker aG = lc.getaGebruiker();
        AZC userAzc = ((AZCMedewerker) aG).getAzc();
        if (userAzc != null) {
            userAzc.toonBerichtenBox();
        } else {
            System.out.println("Gebruiker is niet gekoppeld aan een AZC.");
        }
    }
}
