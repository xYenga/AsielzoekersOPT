package Security;

import java.util.Scanner;

public class LoginC {
    static DataSeeder seeder = DataSeeder.getInstance();
    private static LoginC instance = null;
    private Gebruiker aGebruiker;

    public void setaGebruiker(Gebruiker aGebruiker) {this.aGebruiker = aGebruiker;}

    public LoginC(){setaGebruiker(null);}

    public static LoginC getInstance() {
        if(instance==null){
            instance = new LoginC();
        }
        return instance;
    }

    public Gebruiker getaGebruiker() {return aGebruiker;}
    public boolean isIngelogd(){return getaGebruiker() != null;}

    public static boolean authenticeren(String gebruikersnaam, String wachtwoord) {
        for(Gebruiker g : seeder.getGebruikers()) {
            if(g.getGebruikersnaam().equals(gebruikersnaam) && g.getWachtwoord().equals(wachtwoord)){
                return true;
            }
        }
        return false;
    }

    public Gebruiker logGebruikerIn(String gebruikersnaam, String wachtwoord){
        if (authenticeren(gebruikersnaam, wachtwoord)) {
            Gebruiker g = seeder.getGebruikerByGebruikersnaam(gebruikersnaam);
            if (g != null){
                setaGebruiker(g);
                g.inloggen();
                System.out.println("Welkom " + g.getGebruikersnaam());
                return g;
            } else{
                System.out.println("Gebruiker bestaat niet.");
            }
        } else {
            System.out.println("Ongeldige gebruikersnaam en/of wachtwoord. Probeer opnieuw in te loggen.");
        }
        return null;
    }

    public void inlogMethode() {
        Scanner scan = new Scanner(System.in);
        boolean isIngelogd = false;

        while (!isIngelogd) {
            System.out.println("Voer je gebruikersnaam in: ");
            String gebruikersnaam = scan.nextLine();
            System.out.println();
            System.out.println("Voer je wachtwoord in: ");
            String wachtwoord = scan.nextLine();
            Gebruiker g = logGebruikerIn(gebruikersnaam,wachtwoord);

            if (g != null){
                isIngelogd = true;
            }
            System.out.println();
        }
    }

    public void logoutMethode() {setaGebruiker(null);}
}
