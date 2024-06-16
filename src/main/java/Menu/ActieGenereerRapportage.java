package Menu;

import Model.RapportGenerator;

public class ActieGenereerRapportage implements IActie{
    @Override
    public void voerActieUit() {
        RapportGenerator.getInstance().maakRapport();
    }
}
