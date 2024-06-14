package Menu;

import Model.Vluchteling;

public class ActieRegistreerNieuweAdres implements IActie{
    @Override
    public void voerActieUit() {
        Vluchteling.getInstance().adresRegistreren();
    }
}
