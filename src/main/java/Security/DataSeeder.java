package Security;

import Menu.*;
import Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class DataSeeder {
    private static DataSeeder instance = null;
    private ArrayList<Gebruiker> gebruikers;
    private ArrayList<Gemeente> gemeentes;
    private ArrayList<AZC> azcs;
    private ArrayList<Land> veiligeLanden;
    private ArrayList<Menu> menus;
    private ArrayList<Kamer> kamers;

//    private ArrayList<Observer> observers;

    private boolean initialized = false;

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
        String[] veiligeLandenLijst = {
                "Albanië", "Armenië", "België", "Bosnië-Herzegovina", "Brazilië", "Bulgarije", "Cyprus",
                "Denemarken", "Duitsland", "Estland", "Finland", "Frankrijk", "Georgië", "Ghana",
                "Griekenland", "Hongarije", "Ierland", "India", "Italië", "Jamaica", "Kosovo",
                "Kroatië", "Letland", "Litouwen", "Luxemburg", "Malta", "Marokko", "Mongolië",
                "Montenegro", "Nederland", "Noord-Macedonië", "Oostenrijk", "Polen", "Portugal",
                "Roemenië", "Senegal", "Servië", "Slovenië", "Slowakije", "Spanje", "Trinidad en Tobago",
                "Tsjechië", "Tunesië", "Verenigde Staten", "Verenigd Koninkrijk", "Zweden"
        };

        for (String aLN : alleLandenLijst) {
            if(Arrays.asList(veiligeLandenLijst).contains(aLN)) {
                Land land = new Land(aLN, true);
                veiligeLanden.add(land);
            } else {
                Land land = new Land(aLN, false);
                veiligeLanden.add(land);
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
        }
    }

    public void initializeMenus(){
        Menu nietIngelogd = new Menu("Login Scherm");
        Menukeuze inloggen = new Menukeuze("Login", new ActieLogin());
        Menukeuze exit = new Menukeuze(9, "Exit", true, new ActieExit());
        nietIngelogd.voegMenukeuzeToe(inloggen);
        nietIngelogd.voegMenukeuzeToe(exit);
        menus.add(nietIngelogd);

        Menu beheerderMenu = new Menu("U bent ingelogd als beheerder");
        Menukeuze toonGemeentes = new Menukeuze("Toon Gemeentes", new ActieToonLijstGemeentes());
        Menukeuze genereerRapport = new Menukeuze("Genereer Rapport van alle Gemeentes", new ActieGenereerRapportage());
        Menukeuze logout = new Menukeuze(8,"Logout", new ActieLogout());
        beheerderMenu.voegMenukeuzeToe(toonGemeentes);
        beheerderMenu.voegMenukeuzeToe(genereerRapport);
        beheerderMenu.voegMenukeuzeToe(logout);
        beheerderMenu.voegMenukeuzeToe(exit);
        menus.add(beheerderMenu);

        Menu azcMedewerkerMenu = new Menu("U bent ingelogd als AZC-Medewerker" /*((AZCMedewerker) LoginC.getInstance().getaGebruiker()).getAzc()*/);
        Menukeuze toonBerichtenBox = new Menukeuze("Toon de berichtenbox", new ActieToonBerichtenbox());
        Menukeuze selecteerBericht = new Menukeuze("Selecteer een bericht", new ActieSelecteerBericht());
        azcMedewerkerMenu.voegMenukeuzeToe(toonBerichtenBox);
        azcMedewerkerMenu.voegMenukeuzeToe(selecteerBericht);
        azcMedewerkerMenu.voegMenukeuzeToe(logout);
        azcMedewerkerMenu.voegMenukeuzeToe(exit);
        menus.add(azcMedewerkerMenu);

        Menu coaMedewerkerMenu = new Menu("U bent ingelogd als COA-Medewerker");
        Menukeuze toonVluchteling = new Menukeuze("Toon lijst met vluchtelingen", new ActieToonVluchtelingen());
        Menukeuze registreerVluchteling = new Menukeuze("Registreer een vluchteling", new ActieRegistreerNieuweVluchteling());
        Menukeuze plaatsEnVerhuizingVluchteling = new Menukeuze("Plaats of Verhuis een vluchteling", new ActiePlaatsofVerhuisVluchteling());
        Menukeuze dossierBijWerken = new Menukeuze("Werk het dossier bij van een vluchteling", new ActieWerkDossierBij());
        Menukeuze vertrekNaarLandVanHerkomst = new Menukeuze("Registreer vertrek van vluchteling", new ActieRegistreerVertrekVluchteling());
        coaMedewerkerMenu.voegMenukeuzeToe(toonVluchteling);
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

        LoginC lc = LoginC.getInstance();
        Vluchteling aG = (Vluchteling) lc.getaGebruiker();
        if(aG != null && aG.isPlaatsingInEigenWoningGestart()) {
            vluchtelingMenu.voegMenukeuzeToe(registreerNieuweAdres);
        }

        vluchtelingMenu.voegMenukeuzeToe(logout);
        vluchtelingMenu.voegMenukeuzeToe(exit);
        menus.add(vluchtelingMenu);
    }

    public void initializeGebruikers(){
        gebruikers.add(new Beheerder("admin", "admin123"));
        gebruikers.add(new COAMedewerker("coa_user", "coa123"));

        AZCMedewerker azcMedewerker1 = new AZCMedewerker("Amsterdam_azc_user", "azc123");
        AZCMedewerker azcMedewerker2 = new AZCMedewerker("Rotterdam_azc_user", "azc123");
        AZCMedewerker azcMedewerker3 = new AZCMedewerker("Den_Haag_azc_user", "azc123");

        azcMedewerker1.setAzc(getAZCByNaam("Amsterdam AZC1"));
        azcMedewerker2.setAzc(getAZCByNaam("Rotterdam AZC1"));
        azcMedewerker3.setAzc(getAZCByNaam("Den Haag AZC1"));

        gebruikers.add(azcMedewerker1);
        gebruikers.add(azcMedewerker2);
        gebruikers.add(azcMedewerker3);

        Dossier dossier1 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam1", "Achternaam1", "Mannelijk", new Land("Nederland", true), 25, dossier1 , "gebruikersnaam1", "wachtwoord1"));
        Dossier dossier2 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam2", "Achternaam2", "Vrouwelijk", new Land("Belgie", true), 30, dossier2, "gebruikersnaam2", "wachtwoord2"));
        Dossier dossier3 = new Dossier();
        gebruikers.add(new Model.Vluchteling("Voornaam3", "Achternaam3", "Mannelijk", new Land("Duitsland", true) , 35, dossier3, "gebruikersnaam3", "wachtwoord3"));

        registerObservers();
    }

    public void initializeAZCs(){
        Gemeente amsterdam = getGemeenteByNaam("Amsterdam");
        azcs.add(new AZC("Amsterdam AZC1", new Adres("Damstraat", 1, "1012JS", amsterdam)));
        azcs.add(new AZC("Amsterdam AZC2", new Adres("Kalverstraat", 2, "1012PV", amsterdam)));
        azcs.add(new AZC("Amsterdam AZC3", new Adres("Leidseplein", 3, "1017PT", amsterdam)));

        Gemeente rotterdam = getGemeenteByNaam("Rotterdam");
        azcs.add(new AZC("Rotterdam AZC1", new Adres("Coolsingel", 1, "3012AD", rotterdam)));
        azcs.add(new AZC("Rotterdam AZC2", new Adres("Witte de Withstraat", 2, "3012BT", rotterdam)));

        Gemeente denHaag = getGemeenteByNaam("Den Haag");
        azcs.add(new AZC("Den Haag AZC1", new Adres("Binnenhof", 1, "2513AA", denHaag)));

        Gemeente utrecht = getGemeenteByNaam("Utrecht");
        azcs.add(new AZC("Utrecht AZC1", new Adres("Domplein", 1, "3512JC", utrecht)));
        azcs.add(new AZC("Utrecht AZC2", new Adres("Neude", 2, "3512AD", utrecht)));

        Gemeente eindhoven = getGemeenteByNaam("Eindhoven");
        azcs.add(new AZC("Eindhoven AZC1", new Adres("Stationsplein", 1, "5611AB", eindhoven)));
        azcs.add(new AZC("Eindhoven AZC2", new Adres("Stratumseind", 2, "5611EN", eindhoven)));
        azcs.add(new AZC("Eindhoven AZC3", new Adres("Vestdijk", 3, "5611CA", eindhoven)));

        Gemeente groningen = getGemeenteByNaam("Groningen");
        azcs.add(new AZC("Groningen AZC1", new Adres("Grote Markt", 1, "9712HM", groningen)));
        azcs.add(new AZC("Groningen AZC2", new Adres("Vismarkt", 2, "9712CA", groningen)));

        Gemeente tilburg = getGemeenteByNaam("Tilburg");
        azcs.add(new AZC("Tilburg AZC1", new Adres("Heuvelstraat", 1, "5038AA", tilburg)));

        Gemeente almere = getGemeenteByNaam("Almere");
        azcs.add(new AZC("Almere AZC1", new Adres("Grote Markt", 1, "1315HM", almere)));
        azcs.add(new AZC("Almere AZC2", new Adres("Stationsstraat", 2, "1315KJ", almere)));

        Gemeente breda = getGemeenteByNaam("Breda");
        azcs.add(new AZC("Breda AZC1", new Adres("Grote Markt", 1, "4811XX", breda)));

        Gemeente nijmegen = getGemeenteByNaam("Nijmegen");
        azcs.add(new AZC("Nijmegen AZC1", new Adres("Grote Markt", 1, "6511KB", nijmegen)));
        azcs.add(new AZC("Nijmegen AZC2", new Adres("Molenstraat", 2, "6511HA", nijmegen)));
        azcs.add(new AZC("Nijmegen AZC3", new Adres("Plein 1944", 3, "6511HV", nijmegen)));

        seedKamers(Objects.requireNonNull(getAZCByNaam("Amsterdam AZC1")), Objects.requireNonNull(getAZCByNaam("Rotterdam AZC1")), Objects.requireNonNull(getAZCByNaam("Den Haag AZC1")));
    }

    public void initialize(){
        if(initialized) return;
        initialized = true;

        landenDieVeiligZijn();
        alleGemeentes();
        initializeMenus();
        initializeAZCs();
        initializeGebruikers();

        registerObservers();
    }

    public void registerObservers() {
        ArrayList<Model.Vluchteling> vluchtelingen = getVluchtelingen();
        for (AZC azc : azcs) {
            for (Model.Vluchteling vluchteling : vluchtelingen) {
                vluchteling.registreerObserver(azc);
            }
        }
    }

    public void seedKamers(AZC azc1, AZC azc2, AZC azc3) {
        Kamer jongerenKamer1 = new JongerenKamer(10, "Man", "ja", "Jongeren");
        Kamer gewoneKamer1 = new GewoneKamer(2, "Vrouw", "nee", "Gewone");
        Kamer gewoneKamer1_1 = new GewoneKamer(1, "Vrouw", "ja", "Gewone");
        Kamer gezinsKamer1 = new GezinsKamer(6, "mixed", "ja", "Gezins");

        kamers.add(jongerenKamer1);
        kamers.add(gewoneKamer1);
        kamers.add(gewoneKamer1_1);
        kamers.add(gezinsKamer1);

        azc1.voegKamer(jongerenKamer1);
        azc1.voegKamer(gewoneKamer1);
        azc1.voegKamer(gewoneKamer1_1);
        azc1.voegKamer(gezinsKamer1);

        Kamer jongerenKamer2 = new JongerenKamer(8, "Man", "ja", "Jongeren");
        Kamer gewoneKamer2 = new GewoneKamer(4, "Man", "nee", "Gewone");
        Kamer gezinsKamer2 = new GezinsKamer(5, "mixed", "ja", "Gezins");

        kamers.add(jongerenKamer2);
        kamers.add(gewoneKamer2);
        kamers.add(gezinsKamer2);

        azc2.voegKamer(jongerenKamer2);
        azc2.voegKamer(gewoneKamer2);
        azc2.voegKamer(gezinsKamer2);

        Kamer jongerenKamer3 = new JongerenKamer(15, "Vrouw", "ja", "Jongeren");
        Kamer gewoneKamer3 = new GewoneKamer(1, "Man", "nee", "Gewone");
        Kamer gezinsKamer3 = new GezinsKamer(4, "mixed", "ja", "Gezins");

        kamers.add(jongerenKamer3);
        kamers.add(gewoneKamer3);
        kamers.add(gezinsKamer3);

        azc3.voegKamer(jongerenKamer3);
        azc3.voegKamer(gewoneKamer3);
        azc3.voegKamer(gezinsKamer3);
    }

    DataSeeder(){
        this.gebruikers = new ArrayList<>();
        this.gemeentes = new ArrayList<>();
        this.azcs = new ArrayList<>();
        this.veiligeLanden = new ArrayList<>();
        this.menus = new ArrayList<>();
        this.kamers = new ArrayList<>();
//        this.observers = new ArrayList<>();
    }

    public Gemeente showGemeentes(String gemeente){
        for (Gemeente g : gemeentes) {
            if(g.getNaam().equalsIgnoreCase(gemeente)){
                return g;
            }
        }
        return null;
    }


    public static DataSeeder getInstance(){
        if(instance == null){
            instance = new DataSeeder();
            instance.initialize();
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

    public Menu getMenu() {
        LoginC lc = LoginC.getInstance();

        if (!lc.isIngelogd()) {
            return menus.get(0);
        } else {
            Gebruiker g = lc.getaGebruiker();
            if (g != null) {
                return g.inloggen();
            } else {
                return null;
            }
        }
    }

    public static Gemeente getGemeenteByNaam(String naam) {
        for (Gemeente gemeente : getInstance().getGemeenten()) {
            if (gemeente.getNaam().equals(naam)) {
                return gemeente;
            }
        }
        return null;
    }
    private static AZC getAZCByNaam(String naam) {
        for (AZC azc : getInstance().getAZCs()) {
            if (azc.getNaam().equals(naam)) {
                return azc;
            }
        }
        return null;
    }

    public AZC getAZCByName(String naam) {
        for (AZC azc : azcs) {
            if (azc.getNaam().equalsIgnoreCase(naam)) {
                return azc;
            }
        }
        return null;
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

    public ArrayList<Vluchteling> getVluchtelingen() {
        ArrayList<Vluchteling> vluchtelingen = new ArrayList<>();
        for (Gebruiker g : gebruikers) {
            if (g instanceof Vluchteling) {
                vluchtelingen.add((Vluchteling) g);
            }
        }
        return vluchtelingen;
    }

    public Vluchteling getVluchteling(String naam) {
        for (Vluchteling v : getVluchtelingen()) {
            String vNaam = v.getVoorNaam() + " " + v.getAchterNaam();
            if (vNaam.equalsIgnoreCase(naam)) {
                return v;
            }
        }
        return null;
    }

    public Vluchteling getVluchtelingByNaam(String vNaam, String aNaam) {
        for (Vluchteling v : getVluchtelingen()) {
            if (vNaam.equalsIgnoreCase(v.getVoorNaam()) && aNaam.equalsIgnoreCase(v.getAchterNaam())) {
                return v;
            }
        }
        return null;
    }

    public void showVluchtelingen() {
        for (Vluchteling v : getVluchtelingen()) {
            System.out.println(v.getVoorNaam() + " " + v.getAchterNaam());
        }
    }

    public ArrayList<AZC> getAZCsInGemeente(Gemeente gemeente) {
        ArrayList<AZC> azcPerGemeente = new ArrayList<>();
        for (AZC azc : azcs){
            if (gemeente.getNaam().equalsIgnoreCase(azc.getAdres().getGemeente().getNaam())){
                azcPerGemeente.add(azc);
            }
        }
        return azcPerGemeente;
    }
}
