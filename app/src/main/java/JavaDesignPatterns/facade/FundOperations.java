package JavaDesignPatterns.facade;

public class FundOperations {
    private double balance;

    public FundOperations(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void decreaseBalance(double amountWithDrawn) {
        this.balance -= amountWithDrawn;
    }

    public void increaseBalance(double amountDeposited) {
        this.balance += amountDeposited;
    }

    public boolean isBalanceEnoughForCashWithDrawal(double cashWithdrawal) {
        if (this.balance >= cashWithdrawal) {
            decreaseBalance(cashWithdrawal);
            System.out.println("Cash withdrawal complete. Current balance is £" + this.balance + "\n");
            return true;
        } else {
            System.out.println("Insufficient balance to make cash withdrawal. Current balance is £" + this.balance + "\n");
            return false;
        }
    }

    public void makeCashDeposit(double cashTodeposit) {
        increaseBalance(cashTodeposit);
        System.out.println("Cash deposit completed. The new balance is £" + this.balance + "\n");
    }
}
