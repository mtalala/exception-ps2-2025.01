package br.dev.joaquim;

import java.util.Random;
import java.util.Scanner;

import br.dev.joaquim.bank.BankAccount;
/**
 * classe com atributos e metodos
 */
public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private BankAccount account;

    /**
     * metodo que solicita o nome da conta
     */
    private void welcome() {
        System.out.println("Bem-vindo ao sistema bancário");
        System.out.print("Vamos criar usa conta, informe seu nome: ");
        String holderName = input.nextLine();
        int accountNumber = 1000 + (new Random()).nextInt(8999);
        System.out.println("Criamos uma conta com o número: " + accountNumber + ", com saldo igual a 0 (zero).");
        this.account = new BankAccount(accountNumber, 0, holderName);
    }
    /**
     * exibe o menu
     */
    private void showMenu() {
        System.out.println("\n\n-----------------------");
        System.out.println("Escolha uma das opções:");
        System.out.println("\t1. Verificar dados da conta.");
        System.out.println("\t2. Depositar.");
        System.out.println("\t3. Sacar.");
        System.out.println("\t4. Sair.");
        System.out.print("opção > ");
    }

    /**
     * metodo que inicializa
     */
    public void start() {
        welcome();
        if (account == null)
            return;

        while (true) {
            showMenu();
            try {
                int choice = readOption();
                switch (choice) {
                    case 1:
                        System.out.println("\n" + this.account);
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                    try {
                        withdraw(); // pode dar problema
                    }catch(InsufficientFundsException ex) {
                        System.out.println(ex);
                    }
                        break;
                    case 4:
                        System.out.println("Até a próxima.");
                        return;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                waitUser();
            } catch (NumberFormatException ex) {
                System.out.println("Valor informado não é um número");
            }
        }
    }
    /**
     * solicita o valor para deposito
     */
    private void deposit() {
        System.out.print("\nInforme o valor a ser depositado: ");
        double value = readValue();
        account.deposit(value);
        System.out.println("Desposito realizado com sucesso.");
    }
    /**
     * solicita o valor para saque
     * @throws InsufficientFundsException lança a exceção para quem chamou
     */
    private void withdraw() throws InsufficientFundsException{
        System.out.print("\nInforme o valor a ser sacado: ");
        double value = readValue();
        account.withdraw(value); // pode dar problema
        System.out.println("Saque realizado com sucesso");
    }
    /**
     * leitor
     * @return
     */
    private int readOption() {
        String choiceString = input.nextLine();
        return Integer.parseInt(choiceString);
    }
    /**
     * leitor
     * @return
     */
    private double readValue() {
        String line = input.nextLine();
        return Double.parseDouble(line);
    }
    /**
     * solicita para continuar
     */
    private void waitUser() {
        System.out.println("pressione ENTER para continuar...");
        input.nextLine();
    }
}
