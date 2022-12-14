package JavaDesignPatterns.facade;

public class AccountNumberCheck {

    private int accountNumber = 12345678;

    public boolean isAccountActive(int accountNumber) {
        boolean result = false;
        if (accountNumber == getAccountNumber()) {
            result = true;
        }
        return result;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
