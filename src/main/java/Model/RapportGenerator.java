package Model;

import Security.DataSeeder;

public class RapportGenerator implements IRapport{
    DataSeeder seeder = DataSeeder.getInstance();
    private static RapportGenerator instance = null;

    @Override
    public void maakRapport() {
        for (Gemeente g : seeder.getGemeenten()){
            int percentageOpvang = (int)Math.ceil(g.getAantalInwoners() * 0.005);
            int extraOpgevangen = g.getAantalVluchtelingen() - percentageOpvang;

            int uitkering = 0;
            if(extraOpgevangen > 0){
                if(extraOpgevangen <= 100){
                    uitkering = extraOpgevangen * 1000;
                }else{
                    uitkering = 100 * 1000 + (extraOpgevangen - 100) * 2000;
                }
            }

            System.out.println("Gemeente " + g.getNaam() + ":");
            System.out.println("- Aantal inwoners in de gemeente " + g.getNaam() + ": " + g.getAantalInwoners());
            System.out.println("- Aantal vluchtelingen in de gemeente " + g.getNaam() + ": " + g.getAantalVluchtelingen());
            System.out.println("- Aantal verplichte op te vangen vluchtelingen: " + percentageOpvang);
            System.out.println("- Te krijgen uitkering: €" + uitkering);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }
    public static RapportGenerator getInstance() {
        if(instance==null){
            instance = new RapportGenerator();
        }
        return instance;
    }
}
