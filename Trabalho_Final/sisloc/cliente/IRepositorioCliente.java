package sisloc.cliente;

public interface IRepositorioCliente {
    public void cadastrar(Cliente cliente); // cadastro dos clientes, e não podem haver mais de um cliente com o mesmo CPF
    public Cliente buscar(long cpf); // busca o cliente pelo cpf, e retorna o cliente ou null
    public void atualizar(Cliente cliente); // atualiza o cliente, apenas se já estiver cadastrado
    public void deletar(long cpf); // deleta o cliente, apenas se já estiver cadastrado
    public Cliente[] listar(); // retorna uma lista com todos os clientes cadastrados, ou null caso não hajam
}
