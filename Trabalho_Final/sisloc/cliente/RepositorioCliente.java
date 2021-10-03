package sisloc.cliente;
import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioCliente {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrar(Cliente cliente) {
        try {
            if (buscar(cliente.getCpf()) == null)
                this.clientes.add(cliente);
            else
                throw new IllegalArgumentException(
                    "Cliente já cadastrado.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public Cliente buscar(long cpf) {
        try {
            if ((this.clientes.isEmpty() == false) &&
                (cpf == (long) cpf))
                    for (Cliente cliente : this.clientes)
                        if (cliente.getCpf() == cpf)
                            return cliente;
            else if (cpf != (long) cpf)
                throw new IllegalArgumentException(
                    "Número digitado não é inteiro.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
        
        return null;
    }

    public void atualizar(Cliente cliente) {
        try {
            if (buscar(cliente.getCpf()) != null)
                this.clientes.set(
                    this.clientes.indexOf(cliente),
                        cliente);
            else
                throw new NoSuchFieldException(
                    "Cliente inexistente.");
        } catch (NoSuchFieldException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void deletar(long cpf) {
        Cliente cliente;
        try {
            if ((cliente = buscar(cpf)) != null)
                this.clientes.remove(cliente);
            else
                throw new NoSuchFieldException(
                    "Cliente inexistente.");
        } catch (NoSuchFieldException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public Cliente[] listar() {
        try {
            if (this.clientes.isEmpty() == false) {
                Cliente clientesArray[] =
                    new Cliente[this.clientes.size()];
                return this.clientes.toArray(clientesArray);
            } else
                throw new ArrayIndexOutOfBoundsException(
                    "Nenhum cliente cadastrado.");
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println(erro.getMessage());
        }

        return null;
    }
}
