package Model;

import java.util.ArrayList;

public class Gezin {
    private Vluchteling gezinshoofd;
    private ArrayList<Vluchteling> gezinsleden;

    public Gezin(Vluchteling gezinshoofd) {
        this.gezinshoofd = gezinshoofd;
        this.gezinsleden = new ArrayList<>();
    }

    public void voegGezinslidToe(Vluchteling gezinslid) {
        gezinsleden.add(gezinslid);
    }

    public Vluchteling getGezinshoofd() {
        return gezinshoofd;
    }

    public ArrayList<Vluchteling> getGezinsleden() {
        return gezinsleden;
    }

    public int getAantalGezinsleden() {
        return gezinsleden.size() + 1; // +1 voor het gezinshoofd
    }

    public void setGezinshoofd(Vluchteling gezinshoofd) {
        this.gezinshoofd = gezinshoofd;
    }

}
