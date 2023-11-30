package bonusCalculator.observer;

// Concrete Observer
public class BonusLogger implements BonusObserver {
    public void update(double bonus) {
        System.out.println("Bonus logged: " + bonus);
    }
}
