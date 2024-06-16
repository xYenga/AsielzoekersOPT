package Menu;

import Model.AZC;
import Model.COA;
import Security.AZCMedewerker;
import Security.Gebruiker;
import Security.LoginC;

public class ActieSelecteerBericht implements IActie{
    @Override
    public void voerActieUit() {
        LoginC lc = LoginC.getInstance();
        Gebruiker aG = lc.getaGebruiker();
        AZC userAzc = ((AZCMedewerker) aG).getAzc();
        if (userAzc != null) {
            userAzc.selecteerBericht();
        } else {
            System.out.println("Gebruiker is niet gekoppeld aan een AZC.");
        }
    }
}
