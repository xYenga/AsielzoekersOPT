import Model.*;
import Security.DataSeeder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KamerTest {

    DataSeeder seeder = DataSeeder.getInstance();

    //EQUIVALENTIEKLASSEN EN RANDWAARDEN

    @Test
    public void testToewijzingJongerenKamerLeeftijd0() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "man", seeder.getGeboorteLand("Nederland"), 0, dossier, "test", "password");
        JongerenKamer jongerenKamer = new JongerenKamer(4, "man", "veilig");
        assertTrue(jongerenKamer.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingJongerenKamerLeeftijd17() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "man", seeder.getGeboorteLand("Nederland"), 17, dossier, "test", "password");
        JongerenKamer jongerenKamer = new JongerenKamer(4, "man", "veilig");
        assertTrue(jongerenKamer.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingGeenJongerenKamerLeeftijd18() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "man", seeder.getGeboorteLand("Nederland"), 18, dossier, "test", "password");
        JongerenKamer jongerenKamer = new JongerenKamer(4, "man", "veilig");
        assertFalse(jongerenKamer.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingGewoneKamerLeeftijd18() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 18, dossier, "test", "password");
        GewoneKamer gewoneKamer11 = new GewoneKamer(2, "vrouw", "veilig");
        assertTrue(gewoneKamer11.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingGewoneKamerLeeftijd59() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 59, dossier, "test", "password");
        GewoneKamer gewoneKamer13 = new GewoneKamer(2, "vrouw", "veilig");
        assertTrue(gewoneKamer13.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingOuderenKamerLeeftijd60() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 60, dossier, "test", "password");
        GewoneKamer ouderenKamer12 = new GewoneKamer(1, "vrouw", "veilig");
        assertTrue(ouderenKamer12.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingOuderenKamerLeeftijd59() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 59, dossier, "test", "password");
        GewoneKamer ouderenKamer = new GewoneKamer(1, "vrouw", "veilig");
        assertFalse(ouderenKamer.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingJongerenKamerLeeftijd17_2nd() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 17, dossier, "test", "password");
        JongerenKamer jongerenKamer = new JongerenKamer(4, "vrouw", "veilig");
        assertTrue(jongerenKamer.toewijzingRegel(vluchteling));
    }

    @Test
    public void testToewijzingOuderenKamerLeeftijd60_2nd() {
        Dossier dossier = new Dossier();
        Vluchteling vluchteling = new Vluchteling("test", "test", "vrouw", seeder.getGeboorteLand("Nederland"), 60, dossier, "test", "password");
        GewoneKamer ouderenKamer11 = new GewoneKamer(1, "vrouw", "veilig");
        assertTrue(ouderenKamer11.toewijzingRegel(vluchteling));
    }
}
