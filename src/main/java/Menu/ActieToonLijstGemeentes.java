package Menu;

import Model.Beheerder;

public class ActieToonLijstGemeentes implements IActie{
    @Override
    public void voerActieUit() {
        Beheerder.getInstance().toonGemeentes();
    }
}
