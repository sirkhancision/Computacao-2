package sisloc.operacao;

public class Reserva extends Operacao {
	int prioridade;
	
	public Reserva(long cpf, int codigo) {
		super(cpf, codigo);
	}

	private void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return this.prioridade;
	}
}
