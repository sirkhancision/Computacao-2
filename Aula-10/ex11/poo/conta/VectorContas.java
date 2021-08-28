package poo.conta;
import java.util.Vector;

public class VectorContas implements IRepositorioConta {
	private Vector<ContaAbstrata> contas = new Vector<ContaAbstrata>();

	public void inserir(ContaAbstrata conta) {
		this.contas.add(conta);
	}

	public void remover(String numero) {
		ContaAbstrata conta = procurar(numero);
		this.contas.remove(conta);
	}

	public ContaAbstrata procurar(String numero) {
		int i = 0;
                boolean achou = false;
		for (/*int i*/; i < this.contas.size(); i++)
			if (this.contas.get(i).numero().equals(numero)) {
				achou = true;
				break;
			}
                if (achou == true)
                        return this.contas.get(i);
                else return null;
	}
	
	public ContaAbstrata[] listar() {
		ContaAbstrata[] listaContas = new ContaAbstrata[this.contas.size()];
		for (int i = 0; i < contas.size(); i++)
			listaContas[i] = contas.get(i);
		return listaContas;
	}

	public int numero() {
		return this.contas.size();
	}
}