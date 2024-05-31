package Security;

public class LoginC {
    public void inlogMethode(String gebruikersnaam, String wachtwoord){
        Security.loadGebruikers();

        if(Security.authenticeren(gebruikersnaam, wachtwoord)){
            Gebruiker g = Security.autoriserenGebruiker(gebruikersnaam);

            if(Security.toegangGeven(g, "")){
                g.inloggen();
            }
        }
    }
}
