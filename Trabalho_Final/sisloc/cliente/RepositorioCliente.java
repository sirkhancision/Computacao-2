package sisloc.cliente;
import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioCliente {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrar(Cliente cliente) {
        try {
            buscar(cliente.getCpf());
            throw new IllegalArgumentException(
                "Cliente já cadastrado.\n");
        } catch(ArrayIndexOutOfBoundsException erro) {
            this.clientes.add(cliente);
        }
    }

    public Cliente buscar(long cpf) {
        for (Cliente cliente : this.clientes)
            if (cliente.getCpf() == cpf)
                return cliente;
        
        throw new ArrayIndexOutOfBoundsException("Cliente não cadastrado.\n");
    }

    public void atualizar(Cliente cliente) {
        this.clientes.set(this.clientes.indexOf(buscar(cliente.getCpf())),
            cliente);
    }

    public void deletar(long cpf) {
        Cliente cliente = buscar(cpf);

        this.clientes.remove(cliente);
    }

    public Cliente[] listar() {
        try {
            if (this.clientes.isEmpty() == false) {
                Cliente clientesArray[] =
                    new Cliente[this.clientes.size()];
                return this.clientes.toArray(clientesArray);
            } else
                throw new ArrayIndexOutOfBoundsException(
                    "Nenhum cliente cadastrado.\n");
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println(erro.getMessage());
        }

        return null;
    }
}
