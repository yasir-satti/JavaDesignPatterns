package JavaDesignPatterns.facade;

public class BankAccountApp {

    public static void main(String[] args){

        final int accountNumber = 12345678;
        final int securityCode = 87654321;
        final double startingBalance = 0.00;

        BankAccountFacade xyzBank = new BankAccountFacade(accountNumber, securityCode, startingBalance);

        xyzBank.depositCash(1000.00);
        xyzBank.withdrawCash(570.00);
        xyzBank.depositCash(230.00);

    }
}
