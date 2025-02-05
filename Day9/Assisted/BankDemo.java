import java.util.ArrayList;
class Bank {
    String name;
    ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        this.customers.add(customer);
        customer.setBank(this); // Establish the reverse association
        System.out.println(customer.name + " opened an account at " + this.name);
    }
}

class Customer {
    String name;
    Bank bank; // Association to the Bank

    public Customer(String name) {
        this.name = name;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void viewBalance() { // Simplified balance view
        if (bank != null) {
            System.out.println(name + " views balance at " + bank.name + " (Balance would be here)");
        } else {
            System.out.println(name + " doesn't have an account yet.");
        }
    }
}

class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer customer1 = new Customer("Ayush");
        Customer customer2 = new Customer("Aviral");

        bank.openAccount(customer1);
        bank.openAccount(customer2);

        customer1.viewBalance();
        customer2.viewBalance();

    }
}