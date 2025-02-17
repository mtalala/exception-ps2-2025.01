package br.dev.joaquim.bank;
import br.dev.joaquim.InsufficientFundsException;
/**
 * classe com atributos, metodos e construtores
 */
public class BankAccount {
  private int accountNumber;
  private double balance;
  private String accountHolderName;

  /**
   * construtor
   */
  public BankAccount() {
  }

  /**
   * construtor
   * @param accountNumber numero da conta
   * @param balance saldo
   * @param accountHolderName nome da conta
   */
  public BankAccount(int accountNumber, double balance, String accountHolderName) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.accountHolderName = accountHolderName;
  }
  /**
   * metodo get numero da conta
   */
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * metodo get saldo
   * @return
   */
  public double getBalance() {
    return balance;
  }
  /**
   * metodo get nome da conta
   * @return
   */
  public String getAccountHolderName() {
    return accountHolderName;
  }
  /**
   * metodo para depositar
   * @param value valor desejado
   */
  public void deposit(double value) {

    if (value < 0) {
      throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
    }

    this.balance += value;
  }
/**
 * metodo que realiza saque da conta e instancia exceções
 * @param value valor que deseja sacar
 * @throws InsufficientFundsException lança a exceção para quem chamou
 */
  public void withdraw(double value) throws InsufficientFundsException {

    if (value < 0) {
      throw new IllegalArgumentException("O valor precisa ser positivo, foi informado o valor R$ " + value);
    }

    if (value > this.balance) {
      // Não deveria ser assim, não pode ter print a classe
      throw new InsufficientFundsException("O valor R$ " + value + " é superior ao saldo [R$ " + this.balance + "]");
    }

    this.balance -= value;
  }
  /**
   * metodo que reescreve o toString
   */
  @Override
  public String toString() {
    return "Conta " + accountNumber + " de " + accountHolderName + " têm R$ " + balance + " de saldo";
  }
}
