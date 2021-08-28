import java.util.Scanner;
import java.text.DecimalFormat;
import poo.banco.*;
import poo.conta.*;

public class Main {
        // Para truncar casas decimais em um double
        private static DecimalFormat df = new DecimalFormat("0.00");

        public static void main (String args[]) {
                Scanner input = new Scanner(System.in);
                IRepositorioConta VectorContas = new VectorContas();
                BancoIndependente banco = new BancoIndependente(VectorContas);
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
                                        String numeroConta = input.nextLine();
                                        if (banco.saldo(numeroConta) >= 0)
                                                System.out.println("Saldo: " + df.format(banco.saldo(numeroConta)));
                                        else
                                                System.out.println("Conta inexistente!");
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
                                        switch(opcao) {
                                                case 1:
                                                        Conta contaCorrente = new Conta(input.nextLine());
                                                        banco.cadastrar(contaCorrente);
                                                        break;
                                                case 2:
                                                        ContaPoupanca contaPoupanca = new ContaPoupanca(input.nextLine());
                                                        banco.cadastrar(contaPoupanca);
                                                        break;
                                                case 3:
                                                        ContaEspecial contaEspecial = new ContaEspecial(input.nextLine());
                                                        banco.cadastrar(contaEspecial);
                                                        break;
                                                case 4:
                                                        ContaImposto contaImposto = new ContaImposto(input.nextLine());
                                                        banco.cadastrar(contaImposto);
                                                        break;
                                        }
                                        // Realizar a ação de cadastro com o input dado
                                        System.out.println("Cadastro efetuado!");
                                        break;
                                case 6:
                                        // Teste dos métodos numeroContas e SaldoTotal
                                        System.out.println(banco.numeroContas());
                                        System.out.println(df.format(banco.saldoTotal()));
                                        break;
                                default:
                                        System.exit(0);
                        }
                }
        }
}
