package sisloc.cliente;

public class Cliente {
    private long cpf;
    private String nome;
    private String endereco;

    public Cliente(long cpf) {
        setCpf(cpf);
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void imprimir() {
        System.out.println("Nome: " + (getNome() != null ? getNome() :
            "Indefinido") +
            " | CPF: " + getCpf() +
            " | Endereço: " + (getEndereco() != null ? getEndereco() :
            "Indefinido"));
    }
}