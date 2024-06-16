package Menu;

import Security.LoginC;

public class ActieLogin implements IActie{
    @Override
    public void voerActieUit() {
        LoginC.getInstance().inlogMethode();
    }
}
