package sisloc.operacao;

public class RepositorioOperacao {
	public void cadastrar(Operacao operacao) {

	} // cadastro de operações de reserva ou locação, e alteração de status da locação para ativo

	public Reserva[] buscarReservas(long cpf) {
		
	} // busca reservas ativas do cliente com o cpf dado

	public Locacao[] buscarLocacoes(long cpf) {
		
	} // busca locações ativas do cliente com o cpf dado

	public void deletarReserva(long cpf, int codigo) {
		
	} // altera o status da reserva do filme com dado codigo, reservado pelo cliente de dado cpf, para inativa

	public void deletarLocacao(long cpf, int codigo) {
		
	} // altera o status da locação do filme com dado codigo, reservado pelo cliente de dado cpf, para inativa

	public Locacao[] listarLocacoes(long cpf) {
		
	} // lista todas as locações, ativas e inativas, do cliente com dado cpf

	public int numeroLocacoes(long cpf) {
		
	} // retorna o numero de locações, ativas e inativas, do cliente com dado cpf

	public int numeroLocacoes(int codigo) {
		
	} // retorna o numero de locações, ativas e inativas, feitas do filme com dado código

	public int numeroLocacoesAtivas(long cpf) {
		
	} // retorna o numero de locações ativas do cliente com dado cpf

	public int numeroLocacoesAtivas(int codigo) {
		
	} // retorna o numero de locações ativas do filme com dado código
	
	public int numeroReservas(int codigo) {
		
	} // retorna o numero de reservas ativas do filme com dado código
}
