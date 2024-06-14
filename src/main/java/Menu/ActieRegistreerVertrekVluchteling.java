package Menu;

import Model.Vluchteling;

public class ActieRegistreerVertrekVluchteling implements IActie{
    @Override
    public void voerActieUit() {
        Vluchteling.getInstance().vertrekNaarLandVanHerkomst();
    }
}
