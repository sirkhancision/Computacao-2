package poo.conta;

public class ArrayContas implements IRepositorioConta {
	private ContaAbstrata[] contas;
        private int indice = 0;

	public void inserir(ContaAbstrata conta) {
		contas[indice] = conta;
                indice++;
	}

	public void remover(String numero) {
		indice--;
	}

	public ContaAbstrata procurar(String numero) {
		int i = 0;
                boolean achou = false;
		for (/*int i*/; (!achou) && (i < indice); i++)
			if (contas[i].numero().equals(numero))
				achou = true;
                if (achou == true)
                        return contas[i];
                else return null;
	}

	public ContaAbstrata[] listar() {
		ContaAbstrata[] listaContas = new ContaAbstrata[this.indice];
		for (int i = 0; i < indice; i++)
			listaContas[i] = contas[i];
		return listaContas;
	}

	public int numero() {
		return indice;
	}
}