package sisloc.operacao;
import java.util.ArrayList;

public class RepositorioOperacao {
	private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();

	public void cadastrar(Operacao operacao) {
		operacao.setAtivo(true);
		this.operacoes.add(operacao);
	}

	public Reserva[] buscarReservas(long cpf) {
		Reserva[] reservasAtivasCliente = new Reserva[this.operacoes.size()];
		int index = 0;
		if (this.operacoes.isEmpty() == false) {
			for (Operacao reservas : this.operacoes) {
				if ((reservas instanceof Reserva) && 
					(reservas.getCpf() == cpf) && (reservas.isAtivo() == true)) {
						reservasAtivasCliente[index] = (Reserva) reservas;
						++index;
				}
			}
		}
		return (index > 0) ? reservasAtivasCliente : null;
	}

	public Locacao[] buscarLocacoes(long cpf) {
		Locacao[] locacoesAtivasCliente = new Locacao[this.operacoes.size()];
		int index = 0;
		if (this.operacoes.isEmpty() == false) {
			for (Operacao locacoes : this.operacoes) {
				if ((locacoes instanceof Locacao) && 
					(locacoes.getCpf() == cpf) && (locacoes.isAtivo() == true)) {
						locacoesAtivasCliente[index] = (Locacao) locacoes;
						++index;
				}
			}
		}
		return (index > 0) ? locacoesAtivasCliente : null;
	}

	public void deletarReserva(long cpf, int codigo) {
		Reserva[] reservasCliente = buscarReservas(cpf);
		for (Reserva reservas : reservasCliente) {
			if (reservas.getCodigo() == codigo) {
					reservas.setAtivo(false);
					break;
			}
		}
	} // altera o status da reserva do filme com dado codigo, reservado pelo cliente de dado cpf, para inativa

	public void deletarLocacao(long cpf, int codigo) {
		Locacao[] locacoesCliente = buscarLocacoes(cpf);
		for (Locacao locacoes : locacoesCliente) {
			if (locacoes.getCodigo() == codigo) {
					locacoes.setAtivo(false);
					break;
			}
		}
	} // altera o status da locação do filme com dado codigo, reservado pelo cliente de dado cpf, para inativa

	public Locacao[] listarLocacoes(long cpf) {
		Locacao[] locacoesCliente = new Locacao[this.operacoes.size()];
		int index = 0;
		if (this.operacoes.isEmpty() == false) {
			for (Operacao locacoes : this.operacoes) {
				if ((locacoes instanceof Locacao) && 
					(locacoes.getCpf() == cpf)) {
						locacoesCliente[index] = (Locacao) locacoes;
						++index;
				}
			}
		}
		return (index > 0) ? locacoesCliente : null;
	}

	public int numeroLocacoes(long cpf) {
		return listarLocacoes(cpf).length;
	}

	public int numeroLocacoes(int codigo) {
		int quantidadeLocacoes = 0;
		for (Operacao locacoes : this.operacoes) {
			if ((locacoes instanceof Locacao) &&
				(locacoes.getCodigo() == codigo))
					++quantidadeLocacoes;
		}
		return quantidadeLocacoes;
	}

	public int numeroLocacoesAtivas(long cpf) {
		return buscarLocacoes(cpf).length;
	}

	public int numeroLocacoesAtivas(int codigo) {
		int quantidadeLocacoesAtivas = 0;
		for (Operacao locacoes : this.operacoes) {
			if ((locacoes instanceof Locacao) &&
				(locacoes.getCodigo() == codigo) && (locacoes.isAtivo() == true))
					++quantidadeLocacoesAtivas;
		}
		return quantidadeLocacoesAtivas;
	}
	
	public int numeroReservas(int codigo) {
		int quantidadeReservasAtivas = 0;
		for (Operacao reservas : this.operacoes) {
			if ((reservas instanceof Reserva) &&
				(reservas.getCodigo() == codigo) && (reservas.isAtivo() == true))
					++quantidadeReservasAtivas;
		}
		return quantidadeReservasAtivas;
	}
}
