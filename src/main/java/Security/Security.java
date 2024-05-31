package Security;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Security {
    private static final String BESTANDGEBRUIKERS = "gebruikers.json";
    private static List<Gebruiker> gebruikersInfo = new ArrayList<>();
    private static Gson gson = new Gson();

    static {
        gebruikersInfo.add(new Gebruiker("geb_dummy1","ww_dummy1","Vluchteling",List.of("","")));
        saveGebruikers();
    }

    public static boolean authenticeren(String gebruikersnaam, String wachtwoord) {
        for(Gebruiker g : gebruikersInfo) {
            if(g.getGebruikersnaam().equals(gebruikersnaam) && g.getWachtwoord().equals(wachtwoord)){
                return true;
            }
        }
        return false;
    }

    public static Gebruiker autoriserenGebruiker(String gebruikersnaam) {
        for (Gebruiker g : gebruikersInfo){
            if(g.getGebruikersnaam().equals(gebruikersnaam)){
                return g;
            }
        }
        return null;
    }

    public static boolean toegangGeven(Gebruiker gebruikersnaam, String rechten){
        return gebruikersnaam != null && gebruikersnaam.getRechten().contains(rechten);
    }

    private static void saveGebruikers(){
        try (FileWriter w = new FileWriter(BESTANDGEBRUIKERS)){
            gson.toJson(gebruikersInfo, w);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    static void loadGebruikers(){
        try (FileReader r = new FileReader(BESTANDGEBRUIKERS)){
            Type lijstType =  new TypeToken<List<Gebruiker>>(){}.getType();
            List<Gebruiker> mGebruikersInfo = gson.fromJson(r, lijstType);

            for(Gebruiker mGebruiker : mGebruikersInfo){
                switch (mGebruiker.getRol()){
                    case "Vluchteling":
                        break;
                    case "Beheerder":
                        break;
                    case "AZCMedewerker":
                        break;
                    case "COAMedewerker":
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
