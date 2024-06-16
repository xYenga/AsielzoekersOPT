package Menu;

import Model.Vluchteling;
import Security.Gebruiker;
import Security.LoginC;

public class ActieStatusDossier implements IActie{
    @Override
    public void voerActieUit() {
        LoginC lc = LoginC.getInstance();
        Gebruiker gebruiker = lc.getaGebruiker();
        if(gebruiker instanceof Vluchteling v){
            v.statusDossier();
        }
    }
}
