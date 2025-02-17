package br.dev.joaquim;
/**
 * classe de uma exceção customizada
 * @param message mensagem de alerta
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}