package bonusCalculator.state;

import employee.EmployeeContext;

// State interface
public interface BonusState {
    void handleBonus(EmployeeContext context);
}
