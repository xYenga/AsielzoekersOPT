import Security.AZCMedewerker;
import Security.DataSeeder;
import Security.LoginC;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginCTest {

    private AZCMedewerker azcMedewerkertest1;
    private LoginC lc;

    private DataSeeder seeder;

    @BeforeEach
    public void setupDummy(){
        lc = new LoginC();
        seeder = DataSeeder.getInstance();

        AZCMedewerker azcMedewerkertest1 = new AZCMedewerker("test_azc_user", "azc123");
        seeder.getGebruikers().add(azcMedewerkertest1);
    }

    @AfterEach
    public void verwijderDummy(){
        seeder.getGebruikers().remove(azcMedewerkertest1);
    }


    /* VOORWAARDES:
    *  A: Gebruikersnaam veld is niet leeg.
    *  B: Wachtwoord veld is niet leeg.
    *  C: De combinatie van gebruikersnaam en wachtwoord klopt.
    *
    *  D: De gebruiker wordt ingelogd (besluit D) op basis van de samengestelde decision D = A && B && C.
    * */

    //CONDITION COVERAGE
    @Test
    public void testConditionCoverage(){
        // A = true, B = true, C = true
        assertNotNull(lc.logGebruikerIn("test_azc_user", "azc123"));

        // A = true, B = true, C = false
        assertNull(lc.logGebruikerIn("test_cza_user", "321cza"));

        // A = true, B = false, C = false
        assertNull(lc.logGebruikerIn("test_azc_user", ""));

        // A = false, B = true, C = false
        assertNull(lc.logGebruikerIn("", "azc123"));
    }


    //DECISION COVERAGE
    @Test
    public void testDecisionCoverage(){
        // A = true, B = true, C = true
        assertNotNull(lc.logGebruikerIn("test_azc_user", "azc123"));

        // A = true, B = true, C = false
        assertNull(lc.logGebruikerIn("test_cza_user", "321cza"));
    }

    //CONDITION/DECISION COVERAGE
    @Test
    public void testConditionAndDecisionCoverage(){
        // A = true, B = true, C = true
        assertNotNull(lc.logGebruikerIn("test_azc_user", "azc123"));

        // A = true, B = true, C = false
        assertNull(lc.logGebruikerIn("test_cza_user", "321cza"));

        // A = true, B = false, C = true
        assertNull(lc.logGebruikerIn("test_azc_user", ""));

        // A = false, B = true, C = true
        assertNull(lc.logGebruikerIn("", "azc123"));
    }

    //MODIFIED CONDITION/DECISION COVERAGE
    @Test
    public void testModifiedConditionAndDecisionCoverage(){
        // A = true, B = true, C = true
        assertNotNull(lc.logGebruikerIn("test_azc_user", "azc123"));

        // A = false, B = true, C = true
        assertNull(lc.logGebruikerIn("", "321cza"));

        // A = true, B = false, C = true
        assertNull(lc.logGebruikerIn("test_azc_user", ""));

        // A = true, B = true, C = false
        assertNull(lc.logGebruikerIn("test_azc_user", "321cza"));
    }

    //MULTIPLE CONDITION COVERAGE
    @Test
    public void testMultipleConditionCoverage(){
         // A = true, B = true, C = true
        assertNotNull(lc.logGebruikerIn("test_azc_user", "azc123"));

        // A = true, B = true, C = false
        assertNull(lc.logGebruikerIn("test_cza_user", "321cza"));

        // A = true, B = false, C = false
        assertNull(lc.logGebruikerIn("test_azc_user", ""));

        // A = false, B = true, C = false
        assertNull(lc.logGebruikerIn("", "azc123"));

        // A = true, B = false, C = true
        assertNull(lc.logGebruikerIn("test_azc_user", ""));

        // A = false, B = true, C = true
        assertNull(lc.logGebruikerIn("", "azc123"));

        // A = false, B = false, C = true
        assertNull(lc.logGebruikerIn("", ""));

        // A = false, B = false, C = false
        assertNull(lc.logGebruikerIn("", ""));
    }

}
