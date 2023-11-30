package bonusCalculator.state;

import bonusCalculator.BonusCalculatorBridge;
import employee.Employee;
import employee.EmployeeContext;

class SeniorBonusState implements BonusState {
    public void handleBonus(EmployeeContext context) {
        System.out.println("Senior bonus requested");
        // Implement logic for senior bonus calculation
    }


}