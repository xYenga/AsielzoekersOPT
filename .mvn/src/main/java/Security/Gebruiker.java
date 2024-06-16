package Security;

import Menu.Menu;
import java.util.List;

public abstract class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String rol;

    public Gebruiker(){}

    public Gebruiker(String gebruikersnaam, String wachtwoord, String rol) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.rol = rol;
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

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public abstract Menu inloggen();
}
