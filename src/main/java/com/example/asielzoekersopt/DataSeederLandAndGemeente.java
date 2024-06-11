package com.example.asielzoekersopt;

import Model.Gemeente;
import Model.Land;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSeederLandAndGemeente {
    private List<Land> veiligeLanden = new ArrayList<>();
    int n = 1;
    int m = 1;

    public void landenDieVeiligZijn(){
        String[] alleLandenLijst = {"Afghanistan", "Albanië", "Algerije", "Andorra", "Angola", "Antigua en Barbuda", "Argentinië", "Armenië", "Australië",
                "Azerbeidzjan", "Bahama's", "Bahrein", "Bangladesh", "Barbados", "Belarus", "België", "Belize", "Benin",
                "Bhutan", "Bolivia", "Bosnië-Herzegovina", "Botswana", "Brazilië", "Brunei", "Bulgarije", "Burkina Faso",
                "Burundi", "Cambodja", "Canada", "Centraal-Afrikaanse Republiek", "Chili", "China", "Colombia", "Comoren",
                "Congo-Brazzaville", "Congo-Kinshasa", "Costa Rica", "Cyprus", "Denemarken", "Djibouti", "Dominica",
                "Dominicaanse Republiek", "Duitsland", "Ecuador", "Egypte", "El Salvador", "Equatoriaal-Guinea", "Eritrea",
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
                System.out.println("Veilige Land V" + n + " - " + land.getName());
                n++;
            } else {
                Land land = new Land(aLN, false);
                veiligeLanden.add(land);
                System.out.println("Onveilige Land OV" + m + " - " + land.getName());
                m++;
            }
        }
    }

    public void Gemeente(){
        Object[][] gemeenteLijst = {{"Amsterdam", 931298},{"Rotterdam", 670610},{"Den Haag", 566221},{"Utrecht", 374238},{"Eindhoven", 246417},{"Groningen", 243768},{"Tilburg", 229836},{"Almere", 226500},{"Breda", 188078},{"Nijmegen", 187049}};
        for (Object[] o : gemeenteLijst) {
            String naam = (String)o[0];
            int aantalInwoners = (int)o[1];
            Gemeente gemeente = new Gemeente(naam,aantalInwoners,0);
            System.out.println("Gemeente: " + gemeente.getNaam() + ", Aantal Inwoners: " + gemeente.getAantalInwoners());
        }
    }

    public List<Land> getVeiligeLanden() {
        return veiligeLanden;
    }
}
