package sisloc.operacao;

public class Reserva extends Operacao {
	int prioridade;

	private void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return this.prioridade;
	}
}
