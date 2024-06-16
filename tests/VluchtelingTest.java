import Model.Dossier;
import Model.Land;
import Model.Vluchteling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class VluchtelingTest {

    public void statusDossier(Vluchteling v) {
        if(v.getDossier() != null){
            System.out.println();
            System.out.println("Status van Dossier:");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Asielaanvraag is afgerond: " + (v.getDossier().isAsielAanvraagCompleet() ? "Ja" : "Nee"));
            System.out.println("Uitspraak IND: " + v.getDossier().getUitspraakIND());
            System.out.println("Plaatsing in eigen woning: " + v.getDossier().getPlaatsWoning());
            System.out.println("Teruggekeerd naar het land van herkomst: " + (v.getDossier().isTeruggekeerd() ? "Ja" : "Nee"));
        }else {
            System.out.println("Geen dossier gevonden voor deze vluchteling.");
        }
    }



    //PAIRWISE TESTING

    /* De Volgorde volgt gewoon de volgorde van de Document. Was te lui om namen te verzinnen voor de methoden. :( */
    @Test
    public void testStatusDossier1(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test1","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Geen", "Nee", true);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Geen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier2(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test2","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Geen", "Nee", false);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Geen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }


    @Test
    public void testStatusDossier3(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test3","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Verblijfsvergunning", "Nee", true);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Verblijfsvergunning",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }



    @Test
    public void testStatusDossier4(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test4","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Verblijfsvergunning", "Gestart", false);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Verblijfsvergunning",v.getDossier().getUitspraakIND());
        assertEquals("Gestart",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }


    @Test
    public void testStatusDossier5(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test5","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Verblijfsvergunning", "Afgerond", false);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Verblijfsvergunning",v.getDossier().getUitspraakIND());
        assertEquals("Afgerond",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier6(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test6","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Aanvraag afgewezen", "Nee", true);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Aanvraag afgewezen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier7(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test7","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(true, "Aanvraag afgewezen", "Nee", false);

        statusDossier(v);

        assertTrue(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Aanvraag afgewezen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier8(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test8","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Geen", "Nee", true);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Geen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier9(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test9","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Geen", "Nee", false);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Geen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier10(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test10","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Verblijfsvergunning", "Nee", true);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Verblijfsvergunning",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier11(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test11","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Verblijfsvergunning", "Nee", false);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Verblijfsvergunning",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier12(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test12","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Aanvraag afgewezen", "Nee", true);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Aanvraag afgewezen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertTrue(v.getDossier().isTeruggekeerd());
    }

    @Test
    public void testStatusDossier13(){
        Dossier d = new Dossier();
        Vluchteling v = new Vluchteling("test13","","test", new Land("China"), 30, d,"test","test123");
        d.nieuwDossier(false, "Aanvraag afgewezen", "Nee", false);

        statusDossier(v);

        assertFalse(v.getDossier().isAsielAanvraagCompleet());
        assertEquals("Aanvraag afgewezen",v.getDossier().getUitspraakIND());
        assertEquals("Nee",v.getDossier().getPlaatsWoning());
        assertFalse(v.getDossier().isTeruggekeerd());
    }
}
