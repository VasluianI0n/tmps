package bonusCalculator.command;
import bonusCalculator.BonusCalculator;
import bonusCalculator.StandardBonusCalculator;
import employee.Employee;

// Concrete Command
public class BonusCommandImpl implements BonusCommand {
    private StandardBonusCalculator bonusCalculator;
    private Employee employee;

    public BonusCommandImpl(StandardBonusCalculator bonusCalculator, Employee employee) {
        this.bonusCalculator = bonusCalculator;
        this.employee = employee;
    }

    public void execute() {
        double bonus = bonusCalculator.calculateBonus(employee);
        System.out.println("Bonus calculated: " + bonus);
    }
}