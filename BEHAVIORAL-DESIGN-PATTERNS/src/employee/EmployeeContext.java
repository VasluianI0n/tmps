package employee;

import bonusCalculator.state.BonusState;

// Context
public class EmployeeContext {
    private BonusState bonusState;

    public EmployeeContext(BonusState bonusState) {
        this.bonusState = bonusState;
    }

    public void setBonusState(BonusState bonusState) {
        this.bonusState = bonusState;
    }

    public void requestBonus() {
        bonusState.handleBonus(this);
    }
}