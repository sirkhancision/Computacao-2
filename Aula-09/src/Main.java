import java.util.Scanner;
import banco.*;
import conta.*;

public class Main {
        public static void main (String args[]) {
                Scanner input = new Scanner(System.in);
                BancoVector banco = new BancoVector();
                String numero1, numero2;
                numero1 = numero2 = "";
                double valor = 0;

                // loop infinito
                while(true) {
                        System.out.println("Selecione a operação desejada:\n");
                        System.out.println("[1] - Creditar saldo");
                        System.out.println("[2] - Debitar saldo");
                        System.out.println("[3] - Consultar saldo");
                        System.out.println("[4] - Transferir saldo");
                        System.out.println("[5] - Cadastrar conta\n");
                        System.out.println("Selecione uma opção inexistente para sair");

                        int opcao = input.nextInt();
                        input.nextLine(); // apagar espaço vazio do input
                        switch(opcao) {
                                case 1:
                                        System.out.println("Digite o número da conta:");
                                        numero1 = input.nextLine();
                                        System.out.println("Digite a quantia a ser creditada, usando vírgula para decimais:");
                                        valor = input.nextDouble();
                                        banco.creditar(numero1, valor);
                                        break;
                                case 2:
                                        System.out.println("Digite o número da conta:");
                                        numero1 = input.nextLine();
                                        System.out.println("Digite a quantia a ser debitada, usando vírgula para decimais:");
                                        valor = input.nextDouble();
                                        banco.debitar(numero1, valor);
                                        break;
                                case 3:
                                        System.out.println("Digite o número da conta:");
                                        System.out.println("Saldo: " + banco.saldo(input.nextLine()));
                                        break;
                                case 4:
                                        System.out.println("Digite o número da conta de origem:");
                                        numero1 = input.nextLine();
                                        System.out.println("Digite o número da conta de destino:");
                                        numero2 = input.nextLine();
                                        System.out.println("Digite a quantia a ser transferida, usando vírgula para decimais:");
                                        valor = input.nextDouble();
                                        banco.transferir(numero1, numero2, valor);
                                        break;
                                case 5:
                                        System.out.println("Escolha o tipo da conta a ser criada:");
                                        System.out.println("[1] - Conta Corrente");
                                        System.out.println("[2] - Conta Poupança");
                                        System.out.println("[3] - Conta Especial");
                                        System.out.println("[4] - Conta Imposto");
                                        opcao = input.nextInt();
                                        if (opcao > 4 || opcao < 1) {
                                                System.out.println("Opção invalida");
                                                break;
                                        }

                                        System.out.println("Digite o número da conta nova:");
                                        input.nextLine(); // apagar espaço vazio do input
                                        Conta conta = new Conta(input.nextLine());
                                        // Receber input do número e tipo da conta
                                        banco.cadastrar(conta, opcao);
                                        // Realizar a ação de cadastro com o input dado
                                        System.out.println("Cadastro efetuado!");
                                        break;
                                default:
                                        System.exit(0);
                        }
                }
        }
}
