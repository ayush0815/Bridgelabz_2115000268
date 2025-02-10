// Interface for loan-related operations
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract class representing a Bank Account
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method for interest calculation
    public abstract double calculateInterest();

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

// Concrete class for Savings Account
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04; // 4% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Implementing abstract method
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// Concrete class for Current Account (implements Loanable)
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02; // 2% annual interest
    private static final double LOAN_MULTIPLIER = 5; // Eligible loan is 5x balance

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Implementing abstract method
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    // Implementing Loanable methods
    @Override
    public boolean applyForLoan(double amount) {
        if (amount > 0 && amount <= calculateLoanEligibility()) {
            System.out.println(getHolderName() + " loan approved for: " + amount);
            return true;
        } else {
            System.out.println(getHolderName() + " loan request denied.");
            return false;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_MULTIPLIER;
    }
}
class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV123", "Ayush", 5000);
        BankAccount acc2 = new CurrentAccount("CUR456", "Vaibhav", 10000);

        // Storing accounts in an array
        BankAccount[] accounts = {acc1, acc2};

        // Processing accounts using polymorphism
        for (BankAccount account : accounts) {
            account.displayDetails();
            double interest = account.calculateInterest();
            System.out.println("Interest Earned: " + interest);

            // Handling loans for current accounts
            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                System.out.println("Loan Eligibility: " + loanable.calculateLoanEligibility());
                loanable.applyForLoan(20000); // Attempting a loan request
            }

            System.out.println();
        }
    }
}
