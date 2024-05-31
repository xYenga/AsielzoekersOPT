package Security;

import java.util.List;

public class Vluchteling extends Gebruiker {

    private String rol = "Vluchteling";
    public Vluchteling(String gebruikersnaam, String wachtwoord, String rol, List<String> rechten) {
        super(gebruikersnaam, wachtwoord, rol, rechten);
    }
//    @Override
    public void inloggen() {
        System.out.println("Menu voor de " + rol + ".");
    }
}
