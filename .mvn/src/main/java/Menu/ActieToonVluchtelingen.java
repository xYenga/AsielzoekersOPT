package Menu;

import Model.COA;
import Security.DataSeeder;

public class ActieToonVluchtelingen implements IActie{
    @Override
    public void voerActieUit() {
        COA.getInstance().toonVluchtelingenLijst();
    }
}
