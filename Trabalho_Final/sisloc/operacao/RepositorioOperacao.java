package sisloc.operacao;
import java.util.ArrayList;
import java.util.Date;

public class RepositorioOperacao implements IRepositorioOperacao {
    private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();

    public void cadastrar(Operacao operacao) {
        Date data = new Date(); // Contém a data e hora atuais

        operacao.setAtivo(true);
        operacao.setData(data);

        if (operacao instanceof Locacao)
            ((Locacao) operacao).setPeriodo(0);

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
        
        if (index > 0)
            return reservasAtivasCliente;
        else
            throw new NullPointerException("O cliente não possui reservas.\n");
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

        if (index > 0)
            return locacoesAtivasCliente;
        else
            throw new NullPointerException("O cliente não possui locações.\n");
    }

    public void deletarReserva(long cpf, int codigo) {
        Reserva[] reservasCliente = buscarReservas(cpf);

        for (Reserva reservas : reservasCliente) {
            if (reservas.getCodigo() == codigo) {
                    reservas.setAtivo(false);
                    break;
            }
        }
    }

    public void deletarLocacao(long cpf, int codigo) {
        Locacao[] locacoesCliente = buscarLocacoes(cpf);

        for (Locacao locacoes : locacoesCliente) {
            if (locacoes.getCodigo() == codigo) {
                    locacoes.setAtivo(false);
                    break;
            }
        }
    }

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

        if (index > 0)
            return locacoesCliente;
        else
            throw new NullPointerException("O cliente não possui locações.\n");
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
            Locacao[] locacoes = buscarLocacoes(cpf);
            return locacoes.length;
    }

    public int numeroLocacoesAtivas(int codigo) {
        int quantidadeLocacoesAtivas = 0;

        for (Operacao locacoes : this.operacoes) {
            if ((locacoes instanceof Locacao) &&
                (locacoes.getCodigo() == codigo) &&
                    (locacoes.isAtivo() == true))
                        ++quantidadeLocacoesAtivas;
        }

        return quantidadeLocacoesAtivas;
    }
    
    public int numeroReservas(int codigo) {
        int quantidadeReservasAtivas = 0;
        
        for (Operacao reservas : this.operacoes) {
            if ((reservas instanceof Reserva) &&
                (reservas.getCodigo() == codigo) &&
                    (reservas.isAtivo() == true))
                        ++quantidadeReservasAtivas;
        }
        
        return quantidadeReservasAtivas;
    }
}
