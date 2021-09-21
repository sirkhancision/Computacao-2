package sisloc.operacao;

public class Locacao extends Operacao {
	int periodo;
	
	public Locacao(long cpf, int codigo) {
		super(cpf, codigo);
	}

	private void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getPeriodo() {
		return this.periodo;
	}
}
