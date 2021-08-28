package poo.conta;

public class ContaPoupanca extends Conta {
        public ContaPoupanca (String numero) {
                super(numero);
        }

        public void renderJuros (double taxa) {
                creditar(saldo() * taxa);
        }
}