package sisloc.locadora;

import sisloc.cliente.*;
import sisloc.filme.*;
import sisloc.operacao.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Locadora {
    private IRepositorioFilme filmes;
    private IRepositorioCliente clientes;
    private IRepositorioOperacao operacoes;

    public Locadora(IRepositorioCliente clientes, IRepositorioFilme filmes,
        IRepositorioOperacao operacoes) {
            this.clientes = clientes;
            this.filmes = filmes;
            this.operacoes = operacoes;
    }

    public void cadastrarCliente(Cliente cliente) {
        this.clientes.cadastrar(cliente);
    }

    public Cliente buscarCliente(long cpf) {
        return this.clientes.buscar(cpf);
    }

    public void atualizarCadastroCliente(Cliente cliente) {
        this.clientes.atualizar(cliente);
    }

    public void removerCliente(long cpf) {
        try {
            if (this.operacoes.numeroLocacoesAtivas(cpf) == 0)
            this.clientes.deletar(cpf);
        else
            throw new IllegalArgumentException("Cliente possui locações ativas. Não é possível removê-lo.\n");
        } catch (NullPointerException erro) {
            // caso não existam locações em geral, então o cliente certamente
            // não terá locações ativas, também
            this.clientes.deletar(cpf);
        }
    }

    public void cadastrarFilme(Filme filme) {
        this.filmes.cadastrar(filme);
    }

    public Filme buscarFilme(int codigo) {
        return this.filmes.buscar(codigo);
    }

    public void atualizarCadastroFilme(Filme filme) {
        this.filmes.atualizar(filme);
    }

    public void removerFilme(int codigo) {
        if (this.operacoes.numeroLocacoesAtivas(codigo) == 0)
            this.filmes.deletar(codigo);
        else
            throw new IllegalArgumentException("Filme possui locações ativas. Não é possível removê-lo.\n");
    }

    public void reservarFilme(long cpf, int codigo) {
        Reserva reservaCliente = new Reserva(cpf, codigo);

        if (this.filmes.buscar(codigo).getNumeroCopias() == this.operacoes.numeroLocacoesAtivas(codigo)) {
            reservaCliente.setPrioridade(this.operacoes.numeroReservas(codigo));
            this.operacoes.cadastrar(reservaCliente);
        } else
            throw new IllegalArgumentException("Filme ainda possui cópias disponíveis.\n");
    }

    public void finalizarReservaFilme(long cpf, int codigo) {
        Reserva[] reservasCliente = this.operacoes.buscarReservas(cpf);
        boolean achou = false;

        for (Reserva reservas : reservasCliente) {
            if (reservas.getCodigo() == codigo) {
                this.operacoes.deletarReserva(cpf, codigo);
                achou = true;
                break;
            }
        }

        if (achou == false)
            throw new IllegalArgumentException("Cliente não possui reserva do filme especificado.\n");
    }

    public void locarFilme(long cpf, int codigo) {
        Locacao locacaoCliente = new Locacao(cpf, codigo);

        if (this.filmes.buscar(codigo).getNumeroCopias() > this.operacoes.numeroLocacoesAtivas(codigo)) {
            if (this.operacoes.numeroReservas(codigo) == 0) {
                this.operacoes.cadastrar(locacaoCliente);
            } else {
                try {
                    Reserva[] reservas = this.operacoes.buscarReservas(cpf);
    
                    for (Reserva reserva : reservas) {
                        if (reserva.getCodigo() == codigo && reserva.getPrioridade() == 0)
                            break;
                    }
    
                    this.operacoes.cadastrar(locacaoCliente);
                } catch (NullPointerException erro) {
                    throw new IllegalArgumentException("Filme já possui reservas.\n");
                }
            }
        } else
            throw new IllegalArgumentException("Filme não possui cópias disponíveis.\n");
    }

    public void devolverFilme(long cpf, int codigo) {
        Locacao[] locacoesCliente = this.operacoes.buscarLocacoes(cpf);
        boolean achou = false;

        for (Locacao locacoes : locacoesCliente) {
            if (locacoes.getCodigo() == codigo) {
                this.operacoes.deletarLocacao(cpf, codigo);
                achou = true;
                break;
            }
        }

        if (achou == false)
            throw new IllegalArgumentException("Cliente não possui locação do filme especificado.\n");
    }

    public void imprimirHistoricoLocacoes(long cpf) {
        Locacao[] locacoesCliente = this.operacoes.buscarLocacoes(cpf);
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

        for (Locacao locacoes : locacoesCliente) {
            Filme locacaoFilme = this.filmes.buscar(locacoes.getCodigo());
            System.out.println("Filme: " + locacaoFilme.getTitulo()
                + "\nData da locação: " + formatadorData.format(locacoes.getData()));
        }
        System.out.print("\n");
    }

    // método declarado para que a variavel possa ser usada
    // no comparador abaixo
    protected IRepositorioOperacao getOperacoes() {
        return this.operacoes;
    }

    public void imprimirFilmesMaisLocados(int top) {
        List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(this.filmes.listar()));

        if (top <= filmes.size()) {
            Collections.sort(filmes, new Comparator<Filme>() {
                @Override
                // Faz o sort em ordem decrescente, usando como parâmetro o número de locações do filme
                public int compare(Filme x, Filme y) {
                    IRepositorioOperacao operacoes = getOperacoes();
    
                    return operacoes.numeroLocacoes(y.getCodigo()) - 
                        operacoes.numeroLocacoes(x.getCodigo());
                }
            });

            for (Filme filme : filmes) {
                System.out.println(top + ": " + filme.getTitulo());
                --top;
            }
            System.out.print("\n");
        } else
            throw new ArrayIndexOutOfBoundsException("Tamanho da lista pedido é maior que número de filmes.\n");
    }
}