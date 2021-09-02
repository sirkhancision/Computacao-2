package sisloc.locadora;

import sisloc.cliente.IRepositorioCliente;
import sisloc.filme.IRepositorioFilme;
import sisloc.operacao.IRepositorioOperacao;

public class Locadora {
	IRepositorioFilme filmes;
	IRepositorioCliente clientes;
	IRepositorioOperacao opreacoes;

	public Locadora(IRepositorioCliente clientes, IRepositorioFilme filmes,
	IRepositorioOperacao operacoes) {
		// construtor da classe
	}

	public void cadastrarCliente(Cliente cliente) {
		// cadastro de clientes: apenas um cliente por cpf
	}

	public Cliente buscarCliente(long cpf) {
		// retorna o cliente com dado cpf ou null
	}

	public void atualizarCadastroCliente(Cliente cliente) {
		// atualiza cadastro do cliente, se já estiver cadastrado
	}

	public void removerCliente(long cpf) {
		// remove o cadastro do cliente com dado cpf, se já estiver cadastrado e não tiver locações ativas
	}

	public void cadastrarFilme(Filme filme) {
		// cadastro de filmes: apenas um filme por código
	}

	public Filme buscarFilme(int codigo) {
		// retorna o filme com dado código ou null
	}

	public void atualizarCadastroFilme(Filme filme) {
		// atualiza cadastro do filme, se já estiver cadastrado
	}

	public void removerFilme(int codigo) {
		// remove o cadastro do filme com dado código, se já estiver cadastrado e não tiver locações ativas
	}

	public void reservarFilme(long cpf, int codigo) {
		// reserva o filme com dado código para o cliente com dado cpf, se o cliente estiver cadastrado e não houver copias disponiveis do filme (locacao == copias)
	}

	public void finalizarReservaFilme(long cpf, int codigo) {
		// muda o status da reserva de ativa para inativa, se a reserva de fato existir
	}

	public void locarFilme(long cpf, int codigo) {
		// realiza a locação do filme com dado codigo, para o cliente com dado cpf, se ambos estiverem cadastrados, o filme estiver disponivel (locacao < copias), e se não existir reservas do filme ou a reserva mais antiga ser a do dado cliente
	}

	public void devolverFilme(long cpf, int codigo) {
		// realiza a devolução do filme de dado codigo pelo dado cliente, modificando o status da locação para inativo, se ambos filme e cliente estiverem cadastrados e a locação existir
	}

	public void imprimirHistoricoLocacoes(long cpf) {
		// imprime o historico de locações realizadas pelo dado cliente, se ele estiver cadastrado
	}

	public void imprimirFilmesMaisLocados(int top) {
		// imprime a lista dos filmes mais locados, com o tamanho da lista definido por top, sendo impressa em ordem decrescente (mais locados até os menos locados)
	}
}
