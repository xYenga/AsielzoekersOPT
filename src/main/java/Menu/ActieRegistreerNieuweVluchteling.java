package Menu;

import Model.COA;
import Security.DataSeeder;

public class ActieRegistreerNieuweVluchteling implements IActie{
    @Override
    public void voerActieUit() {
        COA.getInstance().registreerVluchteling();
    }
}
