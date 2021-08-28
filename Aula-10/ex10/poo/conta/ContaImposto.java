package poo.conta;

public class ContaImposto extends ContaAbstrata {
        public ContaImposto(String numero) {
                super(numero);
        }

        public void debitar(double valor) {
                saldo -= valor * 1.001;
        }
}
