package sisloc.operacao;
import java.util.Date;

public class Operacao {
	Date data;
	long cpf;
	int codigo;
	boolean ativo;

	public Operacao(long cpf, int codigo) {
		setCpf(cpf);
		setCodigo(codigo);
	}

	private void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return this.data;
	}

	private void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getCpf() {
		return this.cpf;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	protected void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAtivo() {
		return this.ativo;
	}
}
