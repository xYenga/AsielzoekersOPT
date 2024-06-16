package Model;

import java.util.ArrayList;

public class VluchtelingObservers {
    private ArrayList<Observer> observers;

    public VluchtelingObservers(){
        this.observers = new ArrayList<>();
    }

    public void removeObservers(){
        for (Observer observer : observers) {
            if (observer instanceof AZC) {
                unRegistreerObserver(observer);
            }
        }
    }
    public void registreerObserver(Observer o){
        observers.add(o);
    }
    public void unRegistreerObserver(Observer o){
        observers.remove(o);
    }
    public void notifyObservers(Bericht b){
        for (Observer o : observers){
            o.update(b);
        }
        System.out.println("Bericht verstuurd naar de AZC's.");
    }


}
