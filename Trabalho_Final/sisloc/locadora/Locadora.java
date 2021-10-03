package sisloc.locadora;

import sisloc.cliente.*;
import sisloc.filme.*;
import sisloc.operacao.*;
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
                throw new IllegalArgumentException("Cliente possui locações ativas. Não é possível removê-lo.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
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
        try {
            if (this.operacoes.numeroLocacoesAtivas(codigo) == 0)
                this.filmes.deletar(codigo);
            else
                throw new IllegalArgumentException("Filme possui locações ativas. Não é possível removê-lo.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void reservarFilme(long cpf, int codigo) {
        try {
            if (this.clientes.buscar(cpf) != null) {
                Reserva reservaCliente = new Reserva(cpf, codigo);

                if (this.filmes.buscar(codigo).getNumeroCopias() == this.operacoes.numeroLocacoesAtivas(codigo))
                    this.operacoes.cadastrar(reservaCliente);
                else
                    throw new IllegalArgumentException("Filme ainda possui cópias disponíveis.");
            } else
                throw new IllegalArgumentException("Cliente não cadastrado.");
                
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void finalizarReservaFilme(long cpf, int codigo) {
        try {
            if (this.clientes.buscar(cpf) != null) {
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
                    throw new IllegalArgumentException("Cliente não possui reserva do filme especificado.");
            } else
                throw new IllegalArgumentException("Cliente não cadastrado.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void locarFilme(long cpf, int codigo) {
        try {
            if (this.clientes.buscar(cpf) != null) {
                if (this.filmes.buscar(codigo) != null) {
                    Locacao locacaoCliente = new Locacao(cpf, codigo);

                    if (this.filmes.buscar(codigo).getNumeroCopias() > this.operacoes.numeroLocacoesAtivas(codigo)) {
                        Reserva[] reservas = this.operacoes.buscarReservas(cpf);
                        boolean primeiraReserva = false;

                        for (Reserva reserva : reservas) {
                            if (reserva.getCodigo() == codigo && reserva.getPrioridade() == 0) {
                                primeiraReserva = true;
                                break;
                            }
                        }

                        if (this.operacoes.numeroReservas(codigo) == 0 || primeiraReserva == true)
                            this.operacoes.cadastrar(locacaoCliente);
                        else
                            throw new IllegalArgumentException("Filme já possui reservas.");
                    }
                    else
                        throw new IllegalArgumentException("Filme não possui cópias disponíveis.");
                } else
                    throw new IllegalArgumentException("Filme não cadastrado.");
            } else
                throw new IllegalArgumentException("Cliente não cadastrado.");
                
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void devolverFilme(long cpf, int codigo) {
        try {
            if (this.clientes.buscar(cpf) != null) {
                Locacao[] locacoesCliente = this.operacoes.buscarLocacoes(cpf);
                boolean achou = false;

                if (this.filmes.buscar(codigo) != null) {
                    for (Locacao locacoes : locacoesCliente) {
                        if (locacoes.getCodigo() == codigo) {
                            this.operacoes.deletarLocacao(cpf, codigo);
                            achou = true;
                            break;
                        }
                    }

                    if (achou == false)
                        throw new IllegalArgumentException("Cliente não possui locação do filme especificado.");
                } else
                    throw new IllegalArgumentException("Filme não cadastrado.");
            } else
                throw new IllegalArgumentException("Cliente não cadastrado.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void imprimirHistoricoLocacoes(long cpf) {
        try {
            if (this.clientes.buscar(cpf) != null) {
                Locacao[] locacoesCliente = this.operacoes.buscarLocacoes(cpf);

                for (Locacao locacoes : locacoesCliente) {
                    Filme locacaoFilme = this.filmes.buscar(locacoes.getCodigo());
                    System.out.println("Filme: " + locacaoFilme.getTitulo()
                        + "\nData da locação: " + locacoes.getData());
                }
            } else
                throw new IllegalArgumentException("Cliente não cadastrado.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    // método declarado para que a variavel possa ser usada
    // no comparador abaixo
    protected IRepositorioOperacao getOperacoes() {
        return this.operacoes;
    }

    public void imprimirFilmesMaisLocados(int top) {
        // imprime a lista dos filmes mais locados, com o tamanho da lista definido por top, sendo impressa em ordem decrescente (mais locados até os menos locados)
        try {
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

                for (/* int top */; top > 0; --top) {
                    System.out.println(top + ": " + filmes.get(top).getTitulo());
                }
            } else
                throw new ArrayIndexOutOfBoundsException("Tamanho da lista pedido é maior que número de filmes.");
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println(erro.getMessage());
        }
    }
}