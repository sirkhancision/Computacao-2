package banco;
import java.util.Vector;
import java.text.DecimalFormat;
import conta.Conta;
import conta.ContaPoupanca;
import conta.ContaEspecial;

public class BancoVector {
        private Vector<Conta> BancoVector = new Vector<Conta>();

        // Para truncar casas decimais em um double
        private static DecimalFormat df = new DecimalFormat("0.00");

        // Método modificado para comportar os diferentes tipos de conta
        public void cadastrar (Conta conta, int opcao) {
                switch(opcao) {
                        case 1:
                                BancoVector.add(conta);
                                break;
                        case 2:
                                ContaPoupanca poupanca = new ContaPoupanca(conta.numero());
                                conta = poupanca;
                                BancoVector.add(conta);
                                break;
                        case 3:
                                ContaEspecial especial = new ContaEspecial(conta.numero());
                                conta = especial;
                                BancoVector.add(conta);
                                break;
                }
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

        // Método modificado para comportar os diferentes tipos de creditagem em conta
        public void creditar (String numero, double valor) {
                Conta conta;
                conta = procurar(numero);
                if (conta != null) {
                        if (conta instanceof ContaPoupanca) {
                                conta.creditar(valor);
                                renderJuros(numero);
                        } else if (conta instanceof ContaEspecial) {
                                conta.creditar(valor);
                                renderBonus(numero);
                        } else conta.creditar(valor);
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

        // Modificado para truncar 2 casas decimais e não quebrar o loop da Main
        public String saldo (String numero) {
                Conta conta;
                conta = procurar(numero);
                if (conta == null) {
                        System.out.println("Conta Inexistente!");
                } else System.out.println(df.format(conta.saldo()));
                return ""; // Para retornar alguma coisa qualquer
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

        public void renderJuros (String numero) {
                double taxa = 0.01;
                Conta conta;
                conta = procurar(numero);
                if ((conta != null) && (conta instanceof ContaPoupanca)) {
                        ((ContaPoupanca) conta).renderJuros(taxa);
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }

        public void renderBonus (String numero) {
                Conta conta;
                conta = procurar(numero);
                if ((conta != null) && (conta instanceof ContaEspecial)) {
                        ((ContaEspecial) conta).renderBonus();
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }
}
