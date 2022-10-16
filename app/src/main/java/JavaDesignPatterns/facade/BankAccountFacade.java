package JavaDesignPatterns.facade;

public class BankAccountFacade {

    private final int accountNumber;
    private final int securityCode;

    WelcomeBankMessage welcomeBankMessage;
    AccountNumberCheck accountNumberCheck;
    SecurityCodeCheck securityCodeCheck;
    FundOperations fundOperations;

    public BankAccountFacade(int accountNumber, int securityCode, double startingBalance) {
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;

        welcomeBankMessage = new WelcomeBankMessage();
        accountNumberCheck = new AccountNumberCheck();
        securityCodeCheck = new SecurityCodeCheck();
        fundOperations = new FundOperations(startingBalance);
    }

    public void depositCash(double depositeAmount) {
        fundOperations.makeCashDeposit(depositeAmount);
    }

    public void withdrawCash(double WithDrawAmount) {
        if (accountNumberCheck.isAccountActive(accountNumber) && securityCodeCheck.isSecurityCodeCorrect(securityCode)) {
            if (fundOperations.isBalanceEnoughForCashWithDrawal(WithDrawAmount)) {
                fundOperations.decreaseBalance(WithDrawAmount);
                System.out.println("Cash withdrawal of £" + WithDrawAmount + " is complete. The new balance is £" + fundOperations.getBalance() + "\n");
            } else {
                System.out.println("Transaction failed !");
            }
        }
    }
}
