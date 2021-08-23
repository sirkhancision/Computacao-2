package banco;
import java.util.Vector;
import java.text.DecimalFormat;
import conta.Conta;
import conta.ContaPoupanca;

public class BancoVector {
        private Vector<Conta> BancoVector = new Vector<Conta>();

        public void cadastrar (Conta conta) {
                BancoVector.add(conta);
        }
        private Conta procurar (String numero) {
                int i = 0;
                boolean achou = false;
                while ((!achou) && (i < BancoVector.size())) {
                        if (BancoVector.get(i).numero().equals(numero)) {
                                achou = true;
                        } else {
                                i++;
                        }
                }
                if (achou == true) {
                        return BancoVector.get(i);
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
        // Para truncar casas decimais em um double
        private static DecimalFormat df = new DecimalFormat("0.00");
        public void renderJuros(String numero) {
                double taxa = 0.01;
                Conta conta;
                conta = procurar(numero);
                if ((conta != null) && (conta instanceof ContaPoupanca)) {
                        ((ContaPoupanca) conta).renderJuros(taxa);
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }
}
