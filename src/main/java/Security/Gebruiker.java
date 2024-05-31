package Security;

import java.util.List;

public class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String rol;
    private List<String> rechten;

    public Gebruiker(String gebruikersnaam, String wachtwoord, String rol, List<String> rechten) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
        this.rechten = rechten;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getRol() {
        return rol;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public List<String> getRechten() {
        return rechten;
    }

    public void inloggen() {
        System.out.println("Menu voor de " + rol + ".");
    }
}
