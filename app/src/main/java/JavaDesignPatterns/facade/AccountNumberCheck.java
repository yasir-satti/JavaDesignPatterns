package JavaDesignPatterns.facade;

public class AccountNumberCheck {

    private int accountNumber = 12345678;

    public boolean isAccountActive(int accountNumber) {
        if (accountNumber == getAccountNumber()) {
            return true;
        } else {
            return false;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
