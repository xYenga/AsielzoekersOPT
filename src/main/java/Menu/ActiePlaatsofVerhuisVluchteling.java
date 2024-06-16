package Menu;

import Model.COA;

public class ActiePlaatsofVerhuisVluchteling implements IActie{
    @Override
    public void voerActieUit() {
        COA.getInstance().plaatsingOfVerhuizingVluchteling();
    }
}
