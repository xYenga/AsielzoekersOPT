package Menu;

import Model.IVluchteling;
import Security.Gebruiker;
import Security.LoginC;

public class ActieStatusDossier implements IActie{
    @Override
    public void voerActieUit() {
        LoginC lc = LoginC.getInstance();
        Gebruiker gebruiker = lc.getaGebruiker();
        if(gebruiker instanceof IVluchteling v){
            v.statusDossier();
        }
    }
}
