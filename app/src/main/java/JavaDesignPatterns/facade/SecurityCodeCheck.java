package JavaDesignPatterns.facade;

public class SecurityCodeCheck {
    private int securityCode = 87654321;

    public boolean isSecurityCodeCorrect(int securityCode) {
        boolean result = false;
        if (securityCode == getSecurituCode()){
            result = true;
        }
        return result;
    }

    public int getSecurituCode(){
        return securityCode;
    }
}
