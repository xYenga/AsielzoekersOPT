package Menu;

import Model.COA;

public class ActieWerkDossierBij implements IActie{
    @Override
    public void voerActieUit() {
        COA.getInstance().werkDossierBij();
    }
}
