package JavaDesignPatterns.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void verifyBankAccountNumber(){
        AccountNumberCheck accountNumberCheck = new AccountNumberCheck();
        int accountNumber = 12345678;
        int savedAccountNumber = accountNumberCheck.getAccountNumber();
        assertEquals(accountNumber, savedAccountNumber);
    }

    @Test
    void isBankAccountNumberCorrect(){
        AccountNumberCheck accountNumberCheck = new AccountNumberCheck();
        int accountNumber = 12345678;
        assertTrue(accountNumberCheck.isAccountActive(accountNumber));
    }

    @Test
    void verifySecurityyCode(){
        SecurityCodeCheck securityCodeCheck = new SecurityCodeCheck();
        int securityCode = 87654321;
        int savedSecurituCode = securityCodeCheck.getSecurituCode();
        assertEquals(securityCode, savedSecurituCode);
    }

    @Test
    void isSecurityCodeCorrect(){
        SecurityCodeCheck securityCodeCheck = new SecurityCodeCheck();
        int securityCode = 87654321;
        assertTrue(securityCodeCheck.isSecurityCodeCorrect(securityCode));
    }

    @Test
    void accountBalance(){
        FundOperations fundOperations = new FundOperations(1000.00);
        assertEquals(1000.00,fundOperations.getBalance());
    }

    @Test
    void decreaseAccountBalance(){
        FundOperations fundOperations = new FundOperations(1000.00);
        fundOperations.decreaseBalance(100.00);
        double newBalance = fundOperations.getBalance();
        assertEquals(900.00, newBalance);
    }

    @Test
    void increaseAccountBalance(){
        FundOperations fundOperations = new FundOperations(1000.00);
        fundOperations.increaseBalance(100.00);
        double newBalance = fundOperations.getBalance();
        assertEquals(1100.00, newBalance);
    }

    @Test
    void sufficinetFundsForCashWithDrawal () {
        FundOperations fundOperations = new FundOperations(1000.00);
        double cashWithdrawal = 1000.00;
        assertTrue(fundOperations.isBalanceEnoughForCashWithDrawal(cashWithdrawal));
    }

    @Test
    void NotsufficinetFundsForCashWithDrawal () {
        FundOperations fundOperations = new FundOperations(100.00);
        double cashWithdrawal = 1000.00;
        assertFalse(fundOperations.isBalanceEnoughForCashWithDrawal(cashWithdrawal));
    }

    @Test
    void makeCashDeposit(){
        FundOperations fundOpeations = new FundOperations(0.00);
        fundOpeations.makeCashDeposit(1500.00);
        double newBalance = fundOpeations.getBalance();
        assertEquals(1500.00, newBalance);
    }
}
