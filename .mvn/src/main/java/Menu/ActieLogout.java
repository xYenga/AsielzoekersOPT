package Menu;

import Security.LoginC;

public class ActieLogout implements IActie{
    @Override
    public void voerActieUit() {
        LoginC.getInstance().logoutMethode();
    }
}
