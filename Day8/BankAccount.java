class BankAccount{
    static String bankName;
    private String accountHolderName;
    final private int accountNumber;
    private static int totalAccount;

    BankAccount(String accountHolderName,int accountNumber){
        bankName = "SBI";
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccount++;
    }

    public static int getTotalAccounts(){
        return totalAccount;
    }

    void display(){
        System.out.println("\nBank details: ---------------- ");
        System.out.println("\nAccount holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Bank Name: " + bankName);
    }

    public static void main(String[] args){
        BankAccount account1 = new BankAccount("Ayush Srivastava", 30518597);
        BankAccount account2 = new BankAccount("Aviral Singh",84671234);
        if(account1 instanceof BankAccount){
            System.out.println("Account 1 is instance of BankAccount");
            account1.display();
        }
        System.out.println("\ntotal accounts: " + BankAccount.getTotalAccounts());
    }

}
