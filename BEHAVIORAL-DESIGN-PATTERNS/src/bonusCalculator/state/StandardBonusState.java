package bonusCalculator.state;

import bonusCalculator.BonusCalculatorBridge;
import employee.EmployeeContext;

// Concrete State
public class StandardBonusState implements BonusState, BonusCalculatorBridge {
    public void handleBonus(EmployeeContext context) {
        System.out.println("Standard bonus requested");
        // Implement logic for standard bonus calculation
    }

    @Override
    public double calculateBonus() {
        return 0;
    }
}
