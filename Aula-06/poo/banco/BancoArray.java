package banco;
import conta.Conta;

public class BancoArray {
        private Conta[] contas;
        private int indice = 0;

        public BancoArray () {
                contas = new Conta[100];
        }
        public void cadastrar (Conta conta) {
                contas[indice] = conta;
                indice++;
        }
        private Conta procurar (String numero) {
                int i = 0;
                boolean achou = false;
                while ((!achou) && (i < indice)) {
                        if (contas[i].numero().equals(numero)) {
                                achou = true;
                        } else {
                                i++;
                        }
                }
                if (achou == true) {
                        return contas[i];
                } else {
                        return null;
                }
        }
        public void creditar (String numero, double valor) {
                Conta conta;
                conta = procurar(numero);
                if (conta != null) {
                        conta.creditar(valor);
                        System.out.println("Valor creditado com sucesso!");
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }
        public void debitar (String numero, double valor) {
                Conta conta;
                conta = procurar(numero);
                if (conta != null) {
                        conta.debitar(valor);
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }
        public double saldo (String numero) {
                Conta conta;
                conta = procurar(numero);
                if (conta == null) {
                        System.out.println("Conta Inexistente!");
                        System.exit(1);
                }
                return conta.saldo();
        }
        public void transferir (String origem, String destino,
                double valor) {
                Conta conta1, conta2;
                conta1 = procurar(origem);
                conta2 = procurar(destino);
                if ((conta1 != null) && (conta2 != null)) {
                        conta2.creditar(valor);
                        conta1.debitar(valor);
                        System.out.println("Valor transferido com sucesso!");
                } else if (conta1 == null) {
                        System.out.println("Conta de origem inexistente!");
                } else if (conta2 == null) {
                        System.out.println("Conta de destino inexistente!");
                }
        }
}
