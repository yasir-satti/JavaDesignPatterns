package JavaDesignPatterns.facade;

public class BankAccountApp {

    public static void main(String[] args){

        int accountNumber = 12345678;
        int securityCode = 87654321;

        WelcomeBankMessage welcomeBankMessage = new WelcomeBankMessage();
        double startingBalance = 1000.00;
        double cashToWithDraw = 450.00;
        SecurityCodeCheck securityCodeCheck = new SecurityCodeCheck();
        AccountNumberCheck accountNumberCheck = new AccountNumberCheck();
        FundOperations fundOperations = new FundOperations(startingBalance);

        if (accountNumberCheck.isAccountActive(accountNumber) && securityCodeCheck.isSecurityCodeCorrect(securityCode)) {
            if (fundOperations.isBalanceEnoughForCashWithDrawal(cashToWithDraw)){
                System.out.println("Cash withdrawal complete. New balance £" + fundOperations.getBalance() + "\n");
            } else {
                System.out.println("Transaction failed !");
            }
            double depositeCash = 250;
            fundOperations.makeCashDeposit(depositeCash);
        }
    }
}
