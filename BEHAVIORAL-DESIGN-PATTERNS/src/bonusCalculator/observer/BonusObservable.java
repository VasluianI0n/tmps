package bonusCalculator.observer;

import java.util.ArrayList;
import java.util.List;

// Observable (Subject)
public class BonusObservable {
    private List<BonusObserver> observers = new ArrayList<>();

    public void addObserver(BonusObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BonusObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(double bonus) {
        for (BonusObserver observer : observers) {
            observer.update(bonus);
        }
    }
}
