package bonusCalculator;

import employee.Employee;

public class BonusService {

    //Dependency Inversion Principle
    private BonusCalculator bonusCalculator;

    public BonusService(BonusCalculator bonusCalculator) {
        this.bonusCalculator = bonusCalculator;
    }

    public double calculateBonus(Employee employee) {
        return bonusCalculator.calculateBonus(employee);
    }
}
