package RealLife;
import java.util.*;
public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account" + account);
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance" + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem system = new BankingSystem();
        system.addAccount(1001, 5000);
        system.addAccount(1002, 7000);
        system.requestWithdrawal(1001);
        
        system.processWithdrawals();
        system.displaySortedAccounts();
    }
}
