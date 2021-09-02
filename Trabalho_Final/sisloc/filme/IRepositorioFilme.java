package sisloc.filme;

public interface IRepositorioFilme {
	public void cadastrar(Filme filme); // cadastro dos filmes, apenas um filme com o mesmo código pode ser cadastrado
	public Filme buscar(int codigo); // busca o ffilme pelo código, retornando o filme ou null
	public void atualizar(Filme filme); // atualiza o filme, apenas se ele já estiver cadastrado
	public void deletar(int codigo); // deleta o filme, apenas se ele já estiver cadastrado
	public Filme[] listar(); // retorna a lista de todos os filmes cadastrados, ou null caso não haja filmes
}
