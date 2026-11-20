package mylab.bank.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super("출금 한도를 초과했습니다. 잔액: " + message + "원");
    }
}