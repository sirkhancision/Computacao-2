package poo.banco;
import java.util.Vector;
import poo.conta.*;

public class BancoVector implements IBanco {
        private Vector<ContaAbstrata> BancoVector = new Vector<ContaAbstrata>();

        public void cadastrar (ContaAbstrata conta) {
                BancoVector.add(conta);
        }

        private ContaAbstrata procurar (String numero) {
                int i = 0;
                boolean achou = false;
                while ((!achou) && (i < BancoVector.size())) {
                        if (BancoVector.get(i).numero().equals(numero))
                                achou = true;
                        else i++;
                }
                if (achou == true)
                        return BancoVector.get(i);
                else return null;
        }

        // Método modificado para comportar os diferentes tipos de creditagem em conta
        public void creditar (String numero, double valor) {
                ContaAbstrata conta;
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
                } else
                        System.out.println("Conta Inexistente!");
        }

        public void debitar (String numero, double valor) {
                ContaAbstrata conta;
                conta = procurar(numero);
                if (conta != null)
                        conta.debitar(valor);
                else
                        System.out.println("Conta Inexistente!");
        }

        public double saldo (String numero) {
                ContaAbstrata conta;
		double saldoVar = -1;
                conta = procurar(numero);
                if (conta != null)
                        saldoVar = conta.saldo();
                return saldoVar;
        }

        public void transferir (String origem, String destino, double valor) {
                ContaAbstrata conta1, conta2;
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
                ContaAbstrata conta;
                conta = procurar(numero);
                if ((conta != null) && (conta instanceof ContaPoupanca)) {
                        ((ContaPoupanca) conta).renderJuros(taxa);
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }

        public void renderBonus (String numero) {
                ContaAbstrata conta;
                conta = procurar(numero);
                if ((conta != null) && (conta instanceof ContaEspecial)) {
                        ((ContaEspecial) conta).renderBonus();
                } else {
                        System.out.println("Conta Inexistente!");
                }
        }

        public double saldoTotal() {
                double saldoTotal = 0;
                for (int i = 0; i < BancoVector.size(); i++)
                        saldoTotal += BancoVector.get(i).saldo();
                return saldoTotal;
        }

        public int numeroContas() {
                return BancoVector.size();
        }
}
