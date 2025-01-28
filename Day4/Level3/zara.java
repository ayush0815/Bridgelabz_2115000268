import java.util.Random;
public class zara {
	public static double[][] getEmployeeData() {
    	Random rand = new Random();
    	double[][] employeeData = new double[10][2];
    	for (int i = 0; i < 10; i++) {
        	double salary = 10000 + (rand.nextInt(90000) + 1);
        	int yearsOfService = rand.nextInt(15) + 1;
        	employeeData[i][0] = salary;
        	employeeData[i][1] = yearsOfService;
    	}
    	return employeeData;a
	}
	public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
    	double[][] newSalaryData = new double[10][3];
    	for (int i = 0; i < 10; i++) {
        	double oldSalary = employeeData[i][0];
        	int yearsOfService = (int) employeeData[i][1];
        	double bonus = 0;
        	if (yearsOfService > 5) {
            	bonus = oldSalary * 0.05;
        	} else {
            	bonus = oldSalary * 0.02;
        	}
        	double newSalary = oldSalary + bonus;
        	newSalaryData[i][0] = oldSalary;
        	newSalaryData[i][1] = bonus;
        	newSalaryData[i][2] = newSalary;
    	}
    	return newSalaryData;
	}
	public static void displayResults(double[][] employeeData, double[][] newSalaryData) {
    	double totalOldSalary = 0;
    	double totalNewSalary = 0;
    	double totalBonus = 0;
    	System.out.println("Employee\tOld Salary\tYears of Service\tBonus\tNew Salary");
    	for (int i = 0; i < 10; i++) {
        	double oldSalary = employeeData[i][0];
        	int yearsOfService = (int) employeeData[i][1];
        	double bonus = newSalaryData[i][1];
        	double newSalary = newSalaryData[i][2];
        	System.out.printf("%d\t\t%.2f\t\t%d\t\t\t%.2f\t%.2f\n", i + 1, oldSalary, yearsOfService, bonus, newSalary);
        	totalOldSalary += oldSalary;
        	totalNewSalary += newSalary;
        	totalBonus += bonus;
    	}
    	System.out.printf("\nTotal Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    	System.out.printf("Total Bonus Paid: %.2f\n", totalBonus);
	}
	public static void main(String[] args) {
    	double[][] employeeData = getEmployeeData();
    	double[][] newSalaryData = calculateNewSalaryAndBonus(employeeData);
    	displayResults(employeeData, newSalaryData);
	}
}
