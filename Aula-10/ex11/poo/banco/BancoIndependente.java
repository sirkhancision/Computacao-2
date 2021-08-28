package poo.banco;
import poo.conta.*;

public class BancoIndependente implements IBanco {
        private IRepositorioConta contas;

        public BancoIndependente(IRepositorioConta contas) {
                this.contas = contas;
        }

        public void cadastrar(ContaAbstrata conta) {
                contas.inserir(conta);
        }

        public void debitar(String numero, double valor) {
                ContaAbstrata conta = contas.procurar(numero);
                if (conta != null)
                        conta.debitar(valor);
                else
                        System.out.println("Conta inexistente!");
        }

        public double saldoTotal() {
                double saldoTotal = 0;
                ContaAbstrata listaContas[] = this.contas.listar();
                for (int i = 0; i < this.contas.numero(); i++)
                        saldoTotal += listaContas[i].saldo();
                return saldoTotal;
        }

        public int numeroContas() {
                return this.contas.numero();
        }

        public double saldo (String numero) {
                ContaAbstrata conta;
		double saldoVar = -1;
                conta = this.contas.procurar(numero);
                if (conta != null)
                        saldoVar = conta.saldo();
                return saldoVar;
        }

        public void creditar (String numero, double valor) {
                ContaAbstrata conta;
                conta = this.contas.procurar(numero);
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

        public void transferir (String origem, String destino, double valor) {
                ContaAbstrata conta1, conta2;
                conta1 = this.contas.procurar(origem);
                conta2 = this.contas.procurar(destino);
                if ((conta1 != null) && (conta2 != null)) {
                        conta2.creditar(valor);
                        conta1.debitar(valor);
                        System.out.println("Valor transferido com sucesso!");
                } else if (conta1 == null)
                        System.out.println("Conta de origem inexistente!");
                else if (conta2 == null)
                        System.out.println("Conta de destino inexistente!");
        }

        public void renderJuros (String numero) {
                double taxa = 0.01;
                ContaAbstrata conta;
                conta = this.contas.procurar(numero);
                if ((conta != null) && (conta instanceof ContaPoupanca))
                        ((ContaPoupanca) conta).renderJuros(taxa);
                else
                        System.out.println("Conta Inexistente!");
        }

        public void renderBonus (String numero) {
                ContaAbstrata conta;
                conta = this.contas.procurar(numero);
                if ((conta != null) && (conta instanceof ContaEspecial))
                        ((ContaEspecial) conta).renderBonus();
                else
                        System.out.println("Conta Inexistente!");
        }
}
