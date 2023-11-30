import bonusCalculator.*;
import bonusCalculator.command.BonusCommand;
import bonusCalculator.command.BonusCommandImpl;
import bonusCalculator.observer.BonusLogger;
import bonusCalculator.observer.BonusObservable;
import bonusCalculator.state.StandardBonusState;
import employee.*;

public class TestCase {

    public static void main(String[] args) {

        // Observer example
        BonusObservable bonusObservable = new BonusObservable();
        BonusLogger bonusLogger = new BonusLogger();
        bonusObservable.addObserver(bonusLogger);

        // Command example
        Employee employee = new Employee("John Doe", 1, 50000.0);
        StandardBonusCalculator standardCalculator = new StandardBonusCalculator(employee);
        BonusCommand bonusCommand = new BonusCommandImpl(standardCalculator, employee);

        // State example
        EmployeeContext employeeContext = new EmployeeContext(new StandardBonusState());
        employeeContext.requestBonus();  // Outputs: Standard bonus requested

        // Execute bonus calculation and notify observers
        bonusCommand.execute();
        bonusObservable.notifyObservers(employee.calculateBonus());  // Outputs: Bonus logged: {calculated bonus}
    }


    }


    

