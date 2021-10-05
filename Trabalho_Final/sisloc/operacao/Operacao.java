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

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return this.data;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return this.ativo;
    }
}
