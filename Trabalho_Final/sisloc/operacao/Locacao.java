package sisloc.operacao;

public class Locacao extends Operacao {
	int periodo;

	private void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return this.periodo;
	}
}
