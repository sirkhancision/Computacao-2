package sisloc.cliente;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;

    public Cliente(long cpf) {
        setCpf(cpf);
    }

    private void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void imprimir() {
        System.out.println("Nome: " + getNome() + " | CPF: " + getCpf()
            + " | Endereço: " + getEndereco());
    }
}