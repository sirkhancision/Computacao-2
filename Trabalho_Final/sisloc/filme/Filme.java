package sisloc.filme;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setGenero(Vector<String> genero) {
        this.genero = genero;
    }

    public Vector<String> getGenero() {
        return this.genero;
    }

    public void addGenero(String genero) {
        this.genero.add(genero);
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Date getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setAtores(Vector<String> atores) {
        this.atores = atores;
    }

    public Vector<String> getAtores() {
        return this.atores;
    }

    public void addAtor(String ator) {
        this.atores.add(ator);
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setProdutores(Vector<String> produtores) {
        this.produtores = produtores;
    }

    public Vector<String> getProdutores() {
        return this.produtores;
    }

    public void addProdutor(String produtor) {
        this.produtores.add(produtor);
    }

    public void setPrecoLocacao(float precoLocacao) {
        this.precoLocacao = precoLocacao;
    }

    public float getPrecoLocacao() {
        return this.precoLocacao;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public int getNumeroCopias() {
        return this.numeroCopias;
    }

    public void imprimir() {
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat formatadorFloat = new DecimalFormat("#0.00");

        System.out.println("Título: " + getTitulo() +
            " | Código: " + getCodigo() +
            "\nGêneros: " + (getGenero().isEmpty() == false ? getGenero()
            : "Indefinido") +
            " | Data de Lançamento: " + (getDataLancamento() != null ?
            formatadorData.format(getDataLancamento()) : "Indefinido") +
            "\nAtores: " + (getAtores().isEmpty() == false ? getAtores() :
            "Indefinido") +
            " | Diretor: " + (getDiretor() != null ?
            getDiretor() : "Indefinido") +
            " | Produtores: " + (getProdutores().isEmpty() == false ?
            getProdutores() : "Indefinido") +
            "\nPreço: " + formatadorFloat.format(getPrecoLocacao()) +
            " | Número de cópias: " + getNumeroCopias() +
            "\nSinopse: " + (getSinopse() != null ?
            getSinopse() : "Indefinido"));
    }
}
