package Security;

import Menu.*;
import Model.*;


import java.lang.reflect.Array;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSeeder {
    private static DataSeeder instance = null;
    private ArrayList<Gebruiker> gebruikers;
    private ArrayList<Gemeente> gemeentes;
    private ArrayList<AZC> azcs;
    private ArrayList<Land> veiligeLanden;
    private ArrayList<Menu> menus;
    int n = 1;
    int m = 1;


    public void landenDieVeiligZijn(){
        String[] alleLandenLijst = {"Afghanistan", "Albanië", "Algerije", "Andorra", "Angola", "Antigua en Barbuda", "Argentinië", "Armenië", "Australië",
                "Azerbeidzjan", "Bahama's", "Bahrein", "Bangladesh", "Barbados", "Belarus", "België", "Belize", "Benin",
                "Estland", "Eswatini", "Ethiopië", "Fiji", "Filipijnen", "Finland", "Frankrijk", "Gabon", "Gambia", "Georgië",
                "Ghana", "Griekenland", "Grenada", "Guatemala", "Guinee", "Guinee-Bissau", "Guyana", "Haïti", "Honduras",
                "Hongarije", "Ierland", "IJsland", "India", "Indonesië", "Irak", "Iran", "Israël", "Italië", "Jamaica",
                "Japan", "Jemen", "Jordanië", "Kaapverdië", "Kameroen", "Kazachstan", "Kenya", "Kirgizië", "Kiribati",
                "Kosovo", "Kroatië", "Koeweit", "Laos", "Lesotho", "Letland", "Libanon", "Liberia", "Libië", "Liechtenstein",
                "Litouwen", "Luxemburg", "Madagaskar", "Malawi", "Maldiven", "Maleisië", "Mali", "Malta", "Marokko",
                "Marshalleilanden", "Mauritanië", "Mauritius", "Mexico", "Micronesië", "Moldavië", "Monaco", "Mongolië",
                "Montenegro", "Mozambique", "Myanmar", "Namibië", "Nauru", "Nepal", "Nederland", "Nicaragua", "Nieuw-Zeeland",
                "Niger", "Nigeria", "Noord-Korea", "Noord-Macedonië", "Noorwegen", "Oekraïne", "Oezbekistan", "Oman",
                "Oostenrijk", "Pakistan", "Palau", "Panama", "Papoea-Nieuw-Guinea", "Paraguay", "Peru", "Polen", "Portugal",
                "Qatar", "Roemenië", "Rusland", "Rwanda", "Saint Kitts en Nevis", "Saint Lucia", "Saint Vincent en de Grenadines",
                "Salomonseilanden", "Samoa", "San Marino", "Sao Tomé en Principe", "Saoedi-Arabië", "Senegal", "Servië",
                "Seychellen", "Sierra Leone", "Singapore", "Slovenië", "Slowakije", "Somalië", "Spanje", "Sri Lanka",
                "Suriname", "Syrië", "Tadzjikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad en Tobago",
                "Tsjaad", "Tsjechië", "Tunesië", "Turkije", "Turkmenistan", "Tuvalu", "Uganda", "Uruguay", "Vanuatu",
                "Vaticaanstad", "Venezuela", "Verenigde Arabische Emiraten", "Verenigde Staten", "Verenigd Koninkrijk",
                "Vietnam", "Wit-Rusland", "Zambia", "Zimbabwe", "Zuid-Afrika", "Zuid-Korea", "Zuid-Soedan", "Zweden", "Zwitserland"
        };
//        String[] veiligeLandenLijst = {
//                "Albanië", "Armenië", "België", "Bosnië-Herzegovina", "Brazilië", "Bulgarije", "Cyprus",
//                "Denemarken", "Duitsland", "Estland", "Finland", "Frankrijk", "Georgië", "Ghana",
//                "Griekenland", "Hongarije", "Ierland", "India", "Italië", "Jamaica", "Kosovo",
//                "Kroatië", "Letland", "Litouwen", "Luxemburg", "Malta", "Marokko", "Mongolië",
//                "Montenegro", "Nederland", "Noord-Macedonië", "Oostenrijk", "Polen", "Portugal",
//                "Roemenië", "Senegal", "Servië", "Slovenië", "Slowakije", "Spanje", "Trinidad en Tobago",
//                "Tsjechië", "Tunesië", "Verenigde Staten", "Verenigd Koninkrijk", "Zweden"
//        };

        String[] veiligeLandenLijst = {
                "België", "Bosnië-Herzegovina", "Brazilië", "Bulgarije", "Cyprus",
                "Denemarken", "Duitsland", "Estland", "Finland", "Frankrijk", "Georgië", "Ghana",
                "Nederland", "Tsjechië", "Tunesië", "Verenigde Staten", "Verenigd Koninkrijk", "Zweden"
        };

        for (String aLN : alleLandenLijst) {
            if(Arrays.asList(veiligeLandenLijst).contains(aLN)) {
                Land land = new Land(aLN, true);
                veiligeLanden.add(land);
//                System.out.println("Veilige Land V" + n + " - " + land.getName());
//                n++;
            } else {
                Land land = new Land(aLN, false);
                veiligeLanden.add(land);
//                System.out.println("Onveilige Land OV" + m + " - " + land.getName());
//                m++;
            }
        }
    }
    public void alleGemeentes(){
        Object[][] gemeenteLijst = {{"Amsterdam", 931298},{"Rotterdam", 670610},{"Den Haag", 566221},{"Utrecht", 374238},{"Eindhoven", 246417},{"Groningen", 243768},{"Tilburg", 229836},{"Almere", 226500},{"Breda", 188078},{"Nijmegen", 187049}};
        for (Object[] o : gemeenteLijst) {
            String naam = (String)o[0];
            int aantalInwoners = (int)o[1];
            Gemeente gemeente = new Gemeente(naam,aantalInwoners,0);
            gemeentes.add(gemeente);
//            System.out.println("Gemeente: " + gemeente.getNaam() + ", Aantal Inwoners: " + gemeente.getAantalInwoners());
        }
    }

    public void initialize(){
        landenDieVeiligZijn();
        alleGemeentes();

        //menus
        Menu nietIngelogd = new Menu("Login Scherm");
        Menukeuze inloggen = new Menukeuze("Login", new ActieLogin());
        Menukeuze exit = new Menukeuze(9, "Exit", true, new ActieExit());
        nietIngelogd.voegMenukeuzeToe(inloggen);
        nietIngelogd.voegMenukeuzeToe(exit);
        menus.add(nietIngelogd);

        Menu beheerderMenu = new Menu("U bent ingelogd als beheerder");
        Menukeuze toonGemeentes = new Menukeuze("Toon Gemeentes", new ActieToonLijstGemeentes());
        Menukeuze genereerRapport = new Menukeuze("Genereer Rapport van alle Gemeentes", new ActieGenereerRapportage());
        Menukeuze logout = new Menukeuze("Logout", new ActieLogout());
        beheerderMenu.voegMenukeuzeToe(toonGemeentes);
        beheerderMenu.voegMenukeuzeToe(genereerRapport);
        beheerderMenu.voegMenukeuzeToe(logout);
        beheerderMenu.voegMenukeuzeToe(exit);
        menus.add(beheerderMenu);

        Menu azcMedewerkerMenu = new Menu("U bent ingelogd als AZC-Medewerker");
        Menukeuze toonBerichtenBox = new Menukeuze("Toon de berichtenbox", new ActieToonBerichtenbox());
        Menukeuze selecteerBericht = new Menukeuze("Selecteer een bericht", new ActieSelecteerBericht());
        azcMedewerkerMenu.voegMenukeuzeToe(toonBerichtenBox);
        azcMedewerkerMenu.voegMenukeuzeToe(selecteerBericht);
        azcMedewerkerMenu.voegMenukeuzeToe(logout);
        azcMedewerkerMenu.voegMenukeuzeToe(exit);
        menus.add(azcMedewerkerMenu);

        Menu coaMedewerkerMenu = new Menu("U bent ingelogd als COA-Medewerker");
        Menukeuze registreerVluchteling = new Menukeuze("Registreer een vluchteling", new ActieRegistreerNieuweVluchteling());
        Menukeuze plaatsEnVerhuizingVluchteling = new Menukeuze("Plaats of Verhuis een vluchteling", new ActiePlaatsVluchteling());
        Menukeuze dossierBijWerken = new Menukeuze("Werk het dossier bij van een vluchteling", new ActieWerkDossierBij());
        Menukeuze vertrekNaarLandVanHerkomst = new Menukeuze("Registreer vertrek van vluchteling", new ActieRegistreerVertrekVluchteling());
        coaMedewerkerMenu.voegMenukeuzeToe(registreerVluchteling);
        coaMedewerkerMenu.voegMenukeuzeToe(plaatsEnVerhuizingVluchteling);
        coaMedewerkerMenu.voegMenukeuzeToe(dossierBijWerken);
        coaMedewerkerMenu.voegMenukeuzeToe(vertrekNaarLandVanHerkomst);
        coaMedewerkerMenu.voegMenukeuzeToe(logout);
        coaMedewerkerMenu.voegMenukeuzeToe(exit);
        menus.add(coaMedewerkerMenu);

        Menu vluchtelingMenu = new Menu("U bent ingelogd als vluchteling");
        Menukeuze statusDossier = new Menukeuze("Status van dossier opvragen", new ActieStatusDossier());
        Menukeuze registreerNieuweAdres = new Menukeuze("Registreer nieuwe adres", new ActieRegistreerNieuweAdres());
        vluchtelingMenu.voegMenukeuzeToe(statusDossier);
        vluchtelingMenu.voegMenukeuzeToe(registreerNieuweAdres);
        vluchtelingMenu.voegMenukeuzeToe(logout);
        vluchtelingMenu.voegMenukeuzeToe(exit);
        menus.add(vluchtelingMenu);

        //Gebruikers maken
        gebruikers.add(new Beheerder("admin", "admin123"));
        gebruikers.add(new COAMedewerker("coa_user", "coa123"));
        gebruikers.add(new AZCMedewerker("azc_user", "azc123"));
        gebruikers.add(new Vluchteling("vluchteling", "vluchteling123"));

        Dossier dossier1 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam1", "Achternaam1", "Mannelijk", new Land("Nederland", true), 25, dossier1 , "gebruikersnaam1", "wachtwoord1"));

        Dossier dossier2 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam2", "Achternaam2", "Vrouwelijk", new Land("Belgie", true), 30, dossier2, "gebruikersnaam2", "wachtwoord2"));

        Dossier dossier3 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam3", "Achternaam3", "Mannelijk", new Land("Duitsland", true) , 35, dossier3, "gebruikersnaam3", "wachtwoord3"));

    }

    DataSeeder(){
        this.gebruikers = new ArrayList<>();
        this.gemeentes = new ArrayList<>();
        this.azcs = new ArrayList<>();
        this.veiligeLanden = new ArrayList<>();
        this.menus = new ArrayList<>();
        initialize();
    }
    public static DataSeeder getInstance(){
        if(instance == null){
            instance = new DataSeeder();
        }
        return instance;
    }

    public Menu getBeheerderMenu(){return menus.get(1);}
    public Menu getCOAMedewerkerMenu(){return menus.get(3);}
    public Menu getAZCMedewerkerMenu(){return menus.get(2);}
    public Menu getVluchtelingMenu(){return menus.get(4);}

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public Gebruiker getGebruikerByGebruikersnaam(String gebruikersnaam){
        for (Gebruiker g : gebruikers){
            if(g.getGebruikersnaam().equals(gebruikersnaam)){
                return g;
            }
        }
        return null;
    }

    public Menu getMenu(){
        LoginC lc = LoginC.getInstance();

        if(!lc.isIngelogd()){
            return menus.get(0);
        } else{
            Gebruiker g = lc.getaGebruiker();
            return g.inloggen();
        }
    }

    public ArrayList<Gemeente> getGemeenten() {
        return gemeentes;
    }

    public ArrayList<AZC> getAZCs() {
        return azcs;
    }

    public ArrayList<Land> getVeiligeLanden() {
        return veiligeLanden;
    }

    public Land getGeboorteLand(String geboorteLand){
        for (Land l : veiligeLanden){
            if (l.getName().equalsIgnoreCase(geboorteLand)){
                return l;
            }
        }
        return new Land(geboorteLand, false);
    }

    public Gebruiker getVluchtelingen() {
        for (Gebruiker g : gebruikers){
            if(g.getRol().equals("Vluchteling")){
                return g;
            }
        }
        return null;
    }

//    private Vluchteling getVluchteling(String naam) {
//        for (Vluchteling v : getVluchtelingen()) {
//            if (v.getVoorNaam().equalsIgnoreCase(naam) || v.getAchterNaam().equalsIgnoreCase(naam)) {
//                return v;
//            }
//        }
//        return null;
//    }

}
