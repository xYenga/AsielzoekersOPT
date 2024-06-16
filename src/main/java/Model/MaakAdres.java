package Model;

public class MaakAdres {
    private Adres adres;

    public MaakAdres(Adres adres){
        this.adres = adres;
    }
    public MaakAdres(){}

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    public void printAdres() {
        System.out.println("Adres:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Straatnaam: " + adres.getStraat());
        System.out.println("Huisnummer: " + adres.getNummer());
        System.out.println("Postcode: " + adres.getPostcode());
        System.out.println("Gemeente: " + adres.getGemeente().getNaam());
    }

    public void nieuwAdres(Adres nieuwAdres){
        this.adres = nieuwAdres;
        printAdres();
    }

}
