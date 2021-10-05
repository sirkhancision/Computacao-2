import sisloc.locadora.*;
import sisloc.operacao.*;
import sisloc.filme.*;
import sisloc.cliente.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String args[]) {
        IRepositorioCliente clientes = new RepositorioCliente();
        IRepositorioFilme filmes = new RepositorioFilme();
        IRepositorioOperacao operacoes = new RepositorioOperacao();
        Locadora sisloc = new Locadora(clientes, filmes, operacoes);
        Scanner input = new Scanner(System.in);
        String opcao = "0";

        // Texto inicial
        System.out.println("Bem-vindo ao sistema da locadora Sisloc.\n");
        System.out.println("Opções:");

        while(opcao != null) {
            System.out.println("[1] Cadastrar cliente");
            System.out.println("[2] Buscar cliente");
            System.out.println("[3] Atualizar cliente");
            System.out.println("[4] Histórico de locações de um cliente");
            System.out.println("[5] Remover cliente\n");

            System.out.println("[6] Cadastrar filme");
            System.out.println("[7] Buscar filme");
            System.out.println("[8] Atualizar filme");
            System.out.println("[9] Remover filme\n");

            System.out.println("[A] Reservar filme");
            System.out.println("[B] Finalizar reserva de filme");
            System.out.println("[C] Locar filme");
            System.out.println("[D] Devolver filme");
            System.out.println("[E] Filmes mais locados");
            System.out.println("Insira outra opção para sair do programa.");
        
            opcao = input.nextLine();
        
            switch(opcao) {
                case "1":
                    // Cadastro de clientes
                    System.out.println("Insira o CPF do cliente:");
                    Cliente clienteCadastro = null;
                    try {
                        clienteCadastro = new Cliente(input.nextLong());
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    try {
                        sisloc.cadastrarCliente(clienteCadastro);
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } catch (IllegalArgumentException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "2":
                    // Busca de clientes
                    System.out.println("Insira o CPF do cliente:");
                    long clienteBusca = 0;
                    try {
                        clienteBusca = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    try {
                        sisloc.buscarCliente(clienteBusca).imprimir();
                        System.out.print("\n");
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "3":
                    // Atualização de clientes
                    System.out.println("Insira o CPF do cliente:");
                    Cliente clienteAtualizacao = null;

                    try {
                        clienteAtualizacao = sisloc.buscarCliente(input.nextLong());
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }    

                    System.out.println("Deseja atualizar o nome do cliente? <s/n>");
                    String promptAtualizacaoCliente;

                    // Nome
                    while(true) {
                        promptAtualizacaoCliente = input.nextLine();

                        if (promptAtualizacaoCliente.equals("s") || promptAtualizacaoCliente.equals("S")) {
                            System.out.println("Insira o nome novo do cliente:");
                            clienteAtualizacao.setNome(input.nextLine());
                            break;
                        } else if (promptAtualizacaoCliente.equals("n") || promptAtualizacaoCliente.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar o endereço do cliente? <s/n>");

                    // Endereço
                    while(true) {
                        promptAtualizacaoCliente = input.nextLine();

                        if (promptAtualizacaoCliente.equals("s") || promptAtualizacaoCliente.equals("S")) {
                            System.out.println("Insira o endereço novo do cliente:");
                            clienteAtualizacao.setEndereco(input.nextLine());
                            break;
                        } else if (promptAtualizacaoCliente.equals("n") || promptAtualizacaoCliente.equals("N"))
                            break;
                        else
                            continue;
                    }
                    
                    try {
                        sisloc.atualizarCadastroCliente(clienteAtualizacao);
                        System.out.println("Atualização do cadastro concluído!\n");
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "4":
                    // Histórico de locação de clientes
                    System.out.println("Insira o CPF do cliente:");
                    long clienteHistoricoCpf = 0;
                    try {
                        clienteHistoricoCpf = input.nextLong();
                        sisloc.buscarCliente(clienteHistoricoCpf);
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    try {
                        sisloc.imprimirHistoricoLocacoes(clienteHistoricoCpf);
                    } catch (NullPointerException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "5":
                    // Remoção de clientes
                    System.out.println("Insira o CPF do cliente:");
                    long clienteRemocaoCpf = 0;
                    try {
                        clienteRemocaoCpf = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    System.out.println("Tem certeza que deseja remover o cliente de CPF " + clienteRemocaoCpf + "? <s/n>");
                    String promptRemocaoCliente;

                    while(true) {
                        promptRemocaoCliente = input.nextLine();

                        if (promptRemocaoCliente.equals("s") || promptRemocaoCliente.equals("S")) {
                            try {
                                sisloc.removerCliente(clienteRemocaoCpf);
                                System.out.println("Cliente removido.\n");
                                break;
                            } catch (ArrayIndexOutOfBoundsException erro) {
                                    System.out.println(erro.getMessage());
                                    break;
                            }
                        } else if (promptRemocaoCliente.equals("n") || promptRemocaoCliente.equals("N")) {
                            System.out.println("Operação de remoção abortada.\n");
                            break;
                        }
                        else
                            continue;
                    }
                break;

                case "6":
                    // Cadastro de filmes
                    System.out.println("Insira o código do filme:");
                    int codigo = 0;
                    try {
                        codigo = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    System.out.println("Insira o título do filme:");
                    String titulo = input.nextLine();

                    Filme filmeCadastro = new Filme(codigo, titulo);

                    try {
                        sisloc.cadastrarFilme(filmeCadastro);
                        System.out.println("Cadastro efetuado com sucesso!\n");
                    } catch (IllegalArgumentException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "7":
                    // Busca de filmes
                    System.out.println("Insira o código do filme:");
                    int filmeBusca = 0;
                    try {
                        filmeBusca = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    try {
                        sisloc.buscarFilme(filmeBusca).imprimir();
                        System.out.print("\n");
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "8":
                    // Atualização de filmes
                    System.out.println("Insira o código do filme:");
                    Filme filmeAtualizacao = null;

                    try {
                        filmeAtualizacao = sisloc.buscarFilme(input.nextInt());
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    String promptAtualizacaoFilme;

                    System.out.println("Deseja atualizar o preço de locação do filme? <s/n>");

                    while(true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {                                 
                            System.out.println("Insira preço de locação do filme:");
                            try {
                                float preco = input.nextFloat();
                                filmeAtualizacao.setPrecoLocacao(preco);
                                break;
                            } catch (InputMismatchException erro) {
                                System.out.println("Use vírgula para casas decimais.\n");
                            } finally {
                                input.nextLine(); // limpar buffer
                            }                                    
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar o número de cópias do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            System.out.println("Insira o número de cópias do filme:");
                            while (true) {
                                try {
                                    filmeAtualizacao.setNumeroCopias(input.nextInt());
                                    break;
                                } catch (InputMismatchException erro) {
                                    System.out.println("O número de cópias deve ser um número inteiro válido.\n");
                                } finally {
                                    input.nextLine(); // limpar buffer
                                }
                            }
 
                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }
                    
                    System.out.println("Deseja atualizar os gêneros do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            opcao = "s";

                            while (true) {
                                if (opcao.equals("s") || opcao.equals("S")) {
                                    System.out.print("Gênero: ");
                                    filmeAtualizacao.addGenero(input.nextLine());
                                    System.out.println("Continuar? <s/n>");
                                    opcao = input.nextLine();
                                } else if (opcao.equals("n") || opcao.equals("N"))
                                    break;
                                else
                                    continue;
                            }  
                            
                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }
                    
                    System.out.println("Deseja atualizar a data de lançamento do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            System.out.println("Insira a data de lançamento do filme (dd/mm/aaaa):");
                            Date dataLancamento = null;
                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                            while (true) {
                                try {
                                    dataLancamento = format.parse(input.nextLine());
                                    filmeAtualizacao.setDataLancamento(dataLancamento);
                                    break;
                                } catch (ParseException erro) {
                                    System.out.println("Formato de data inválido.");
                                }
                            }

                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar o diretor do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            System.out.println("Insira o nome do diretor do filme:");
                            filmeAtualizacao.setDiretor(input.nextLine());
                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar os atores do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            opcao = "s"; 

                            while (true) {
                                if (opcao.equals("s") || opcao.equals("S")) {
                                    System.out.print("Ator: ");
                                    filmeAtualizacao.addAtor(input.nextLine());
                                    System.out.println("Continuar? <s/n>");
                                    opcao = input.nextLine();
                                } else if (opcao.equals("n") || opcao.equals("N"))
                                    break;
                                else
                                    continue;                          
                            }

                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar os produtores do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            opcao = "s";

                            while (true) {
                                if (opcao.equals("s") || opcao.equals("S")) {
                                    System.out.print("Produtor: ");
                                    filmeAtualizacao.addProdutor(input.nextLine());
                                    System.out.println("Continuar? <s/n>");
                                    opcao = input.nextLine();
                                } else if (opcao.equals("n") || opcao.equals("N"))
                                    break;
                                else
                                    continue;                                
                            }

                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    System.out.println("Deseja atualizar a sinopse do filme? <s/n>");

                    while (true) {
                        promptAtualizacaoFilme = input.nextLine();

                        if (promptAtualizacaoFilme.equals("s") || promptAtualizacaoFilme.equals("S")) {
                            System.out.println("Insira a sinopse do filme:");
                            filmeAtualizacao.setSinopse(input.nextLine());
                            break;
                        } else if (promptAtualizacaoFilme.equals("n") || promptAtualizacaoFilme.equals("N"))
                            break;
                        else
                            continue;
                    }

                    try {
                        sisloc.atualizarCadastroFilme(filmeAtualizacao);
                        System.out.println("Atualização do cadastro concluído!\n");
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "9":
                    // Remoção de filmes
                    System.out.println("Insira o código do filme:");
                    int filmeRemocaoCodigo = 0;
                    try {
                        filmeRemocaoCodigo = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }

                    System.out.println("Tem certeza que deseja remover o filme de código " + filmeRemocaoCodigo + "? <s/n>");
                    String promptRemocaoFilme;

                    while(true) {
                        promptRemocaoFilme = input.nextLine();

                        if (promptRemocaoFilme.equals("s") || promptRemocaoFilme.equals("S")) {
                            try {
                                sisloc.removerFilme(filmeRemocaoCodigo);
                                System.out.println("Filme removido.\n");
                                break;
                            } catch (NullPointerException |
                                ArrayIndexOutOfBoundsException |
                                IllegalArgumentException erro) {
                                    System.out.println(erro.getMessage());
                                    break;
                            }
                        } else if (promptRemocaoFilme.equals("n") || promptRemocaoFilme.equals("N")) {
                            System.out.println("Operação de remoção abortada.\n");
                            break;
                        }
                        else
                            continue;
                    }
                break;

                case "A":
                case "a":
                    // Reserva de filmes
                    System.out.println("Insira o CPF do cliente que quer realizar a reserva:");
                    long cpfReserva = 0;
                    try {
                        cpfReserva = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarCliente(cpfReserva);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    System.out.println("Insira o código do filme que gostaria de reservar:");
                    int codigoReserva = 0;
                    try {
                        codigoReserva = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarFilme(codigoReserva);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    try {
                        sisloc.reservarFilme(cpfReserva, codigoReserva);
                        System.out.println("Reserva feita com sucesso!\n");
                    } catch (IllegalArgumentException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "B":
                case "b":
                    // Finalizar reserva de filmes
                    System.out.println("Insira o CPF do cliente para finalizar a reserva:");
                    long cpfFinalizarReserva = 0;
                    try {
                        cpfFinalizarReserva = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarCliente(cpfFinalizarReserva);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    System.out.println("Insira o código do filme reservado:");
                    int codigoFinalizarReserva = 0;
                    try {
                        codigoFinalizarReserva = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarFilme(codigoFinalizarReserva);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    try {
                        sisloc.finalizarReservaFilme(cpfFinalizarReserva, codigoFinalizarReserva);
                        System.out.println("Reserva finalizada com sucesso!\n");
                    } catch (IllegalArgumentException |
                        NullPointerException erro) {
                            System.out.println(erro.getMessage());
                    }
                break;

                case "C":
                case "c":
                    // Locação de filmes
                    System.out.println("Insira o CPF do cliente que quer realizar a locação:");
                    long cpfLocacao = 0;
                    try {
                        cpfLocacao = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarCliente(cpfLocacao);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    System.out.println("Insira o código do filme que gostaria de locar:");
                    int codigoLocacao = 0;
                    try {
                        codigoLocacao = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarFilme(codigoLocacao);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    try {
                        sisloc.locarFilme(cpfLocacao, codigoLocacao);
                        System.out.println("Locação feita com sucesso!\n");
                    } catch (IllegalArgumentException erro) {
                        System.out.println(erro.getMessage());
                    }
                break;

                case "D":
                case "d":
                    // Devolução de filmes
                    System.out.println("Insira o CPF do cliente que realizou a locação:");
                    long cpfDevolucao = 0;
                    try {
                        cpfDevolucao = input.nextLong();
                    } catch (InputMismatchException erro) {
                        System.out.println("O CPF deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarCliente(cpfDevolucao);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    System.out.println("Insira o código do filme que foi locado:");
                    int codigoDevolucao = 0;
                    try {
                        codigoDevolucao = input.nextInt();
                    } catch (InputMismatchException erro) {
                        System.out.println("O código do filme deve ser um número inteiro válido.\n");
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                    
                    try {
                        sisloc.buscarFilme(codigoDevolucao);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    }

                    try {
                        sisloc.devolverFilme(cpfDevolucao, codigoDevolucao);
                        System.out.println("Devolução feita com sucesso!\n");
                    } catch (IllegalArgumentException |
                        NullPointerException erro) {
                            System.out.println(erro.getMessage());
                    } 
                break;

                case "E":
                case "e":
                    // Filmes mais locados
                    System.out.println("Quantos filmes gostaria de imprimir?");
                    try {
                        sisloc.imprimirFilmesMaisLocados(input.nextInt());
                    } catch (InputMismatchException erro) {
                        System.out.println("O número de filmes deve ser um número inteiro válido.\n");
                        break;
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        System.out.println(erro.getMessage());
                        break;
                    } finally {
                        input.nextLine(); // limpar buffer
                    }
                break;

                default:
                    opcao = null;
            }
        }

        input.close();
    }
}