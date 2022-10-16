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
        boolean result = false;
        if (this.balance >= cashWithdrawal) {
//            decreaseBalance(cashWithdrawal);
//            System.out.println("Cash withdrawal of £" + cashWithdrawal + " is complete. The new balance is £" + this.balance + "\n");
            result = true;
        } else {
            System.out.println("Insufficient balance to make cash withdrawal of £" + cashWithdrawal + ". Current balance is £" + this.balance + "\n");
        }
        return result;
    }

    public void makeCashDeposit(double cashTodeposit) {
        increaseBalance(cashTodeposit);
        System.out.println("Cash deposit of £" + cashTodeposit + " is completed. The new balance is £" + this.balance + "\n");
    }
}
