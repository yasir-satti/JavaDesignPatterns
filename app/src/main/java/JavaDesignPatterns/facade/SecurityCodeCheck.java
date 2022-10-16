package JavaDesignPatterns.facade;

public class SecurityCodeCheck {
    private int securityCode = 87654321;

    public boolean isSecurityCodeCorrect(int securityCode) {
        if (securityCode == getSecurituCode()){
            return true;
        } else {
            return false;
        }
    }

    public int getSecurituCode(){
        return securityCode;
    }
}
