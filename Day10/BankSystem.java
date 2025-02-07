// Base class: BankAccount
class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: Rs" + amount);
        System.out.println("New Balance: Rs" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
            System.out.println("Remaining Balance: Rs" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs" + balance);
    }

    public void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Applied: Rs" + interest);
        System.out.println("New Balance: Rs" + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal failed! Limit exceeded: Rs" + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // In months

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    public void displayMaturityDetails() {
        System.out.println("Maturity Period: " + maturityPeriod + " months");
        System.out.println("Balance at Maturity: Rs" + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

// Main class to test the hierarchy
public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA12345", 5000, 5);
        CheckingAccount ca = new CheckingAccount("CA67890", 3000, 1000);
        FixedDepositAccount fda = new FixedDepositAccount("FDA54321", 10000, 12);

        System.out.println("\n--- Savings Account ---");
        sa.displayAccountType();
        sa.displayBalance();
        sa.applyInterest();

        System.out.println("\n--- Checking Account ---");
        ca.displayAccountType();
        ca.displayBalance();
        ca.withdraw(1200); // Exceeds withdrawal limit
        ca.withdraw(800);  // Allowed

        System.out.println("\n--- Fixed Deposit Account ---");
        fda.displayAccountType();
        fda.displayBalance();
        fda.displayMaturityDetails();
    }
}
