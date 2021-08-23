import java.util.Scanner;

public class Main {
        public static void main (String args[]) {
                Scanner input = new Scanner(System.in);
                Banco banco = new Banco();
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
                        System.out.println
                        ("Selecione uma opção inexistente para sair");

                        int opcao = input.nextInt();
                        input.nextLine(); // apagar espaço vazio do input
                        switch(opcao) {
                                case 1:
                                        System.out.println
                                        ("Digite o número da conta:");
                                        numero1 = input.nextLine();
                                        System.out.println
                                        ("Digite a quantia a ser creditada:");
                                        valor = input.nextDouble();
                                        banco.creditar(numero1, valor);
                                        break;
                                case 2:
                                        System.out.println
                                        ("Digite o número da conta:");
                                        numero1 = input.nextLine();
                                        System.out.println
                                        ("Digite a quantia a ser debitada:");
                                        valor = input.nextDouble();
                                        banco.debitar(numero1, valor);
                                        break;
                                case 3:
                                        System.out.println
                                        ("Digite o número da conta:");
                                        System.out.println("Saldo: " +
                                        banco.saldo(input.nextLine()));
                                        break;
                                case 4:
                                        System.out.println
                                        ("Digite o número da conta de origem:");
                                        numero1 = input.nextLine();
                                        System.out.println
                                        ("Digite o número da conta de destino:");
                                        numero2 = input.nextLine();
                                        System.out.println
                                        ("Digite a quantia a ser transferida:");
                                        valor = input.nextDouble();
                                        banco.transferir
                                        (numero1, numero2, valor);
                                        break;
                                case 5:
                                        System.out.println
                                        ("Digite o número da conta nova:");
                                        Conta conta = new Conta
                                        (input.nextLine());
                                        // Receber input do número da conta
                                        banco.cadastrar(conta);
                                        /* Realizar a ação de cadastro com o
                                        input dado */
                                        System.out.println
                                        ("Cadastro efetuado!");
                                        break;
                                default:
                                        System.exit(0);
                        }
                }
        }
}
