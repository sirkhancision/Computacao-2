package sisloc.filme;
import java.util.Date;
import java.util.Vector;

public class Filme {
	int codigo;
	String titulo;
	Vector<String> genero = new Vector<>();
	Date dataLancamento;
	String diretor;
	Vector<String> atores = new Vector<>();
	String sinopse;
	Vector<String> produtores = new Vector<>();
	float precoLocacao;
	int numeroCopias;

	public Filme(int codigo, String titulo) {
		setCodigo(codigo);
		setTitulo(titulo);
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	private void setGenero(Vector<String> genero) {
		this.genero = genero;
	}

	public Vector<String> getGenero() {
		return this.genero;
	}

	private void addGenero(String genero) {
		this.genero.add(genero);
	}

	private void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataLancamento() {
		return this.dataLancamento;
	}

	private void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getDiretor() {
		return this.diretor;
	}

	private void setAtores(Vector<String> atores) {
		this.atores = atores;
	}

	public Vector<String> getAtores() {
		return this.atores;
	}

	private void addAtor(String ator) {
		this.atores.add(ator);
	}

	private void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getSinopse() {
		return this.sinopse;
	}

	private void setProdutores(Vector<String> produtores) {
		this.produtores = produtores;
	}

	public Vector<String> getProdutores() {
		return this.produtores;
	}

	private void addProdutor(String produtor) {
		this.produtores.add(produtor);
	}

	private void setPrecoLocacao(float precoLocacao) {
		this.precoLocacao = precoLocacao;
	}

	public float getPrecoLocacao() {
		return this.precoLocacao;
	}

	private void setNumeroCopias(int numeroCopias) {
		this.numeroCopias = numeroCopias;
	}

	public int getNumeroCopias() {
		return this.numeroCopias;
	}

	public void imprimir() {
		System.out.println("Título: " + getTitulo() + " | Código: " +
		getCodigo() + "\nGêneros: " + getGenero() +
		" | Data de Lançamento: " + getDataLancamento() + "\nAtores: "
		+ getAtores() + " | Diretor: " + getDiretor() + "\nSinopse: " +
		getSinopse());
	}
}
