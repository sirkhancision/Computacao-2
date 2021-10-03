package sisloc.filme;
import java.util.ArrayList;

public class RepositorioFilme {
    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public void cadastrar(Filme filme) {
        try {
            if (buscar(filme.getCodigo()) == null)
                this.filmes.add(filme);
            else
                throw new IllegalArgumentException(
                    "Filme já cadastrado.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public Filme buscar(int codigo) {
        try {
            if ((this.filmes.isEmpty() == false) &&
                (codigo == (int) codigo))
                    for (Filme filme : this.filmes)
                        if (filme.getCodigo() == codigo)
                            return filme;
            else if (codigo != (int) codigo)
                throw new IllegalArgumentException(
                    "Número digitado não é inteiro.");
        } catch (IllegalArgumentException erro) {
            System.out.println(erro.getMessage());
        }
        
        return null;
    }
    
    public void atualizar(Filme filme) {
        try {
            if (buscar(filme.getCodigo()) != null)
                this.filmes.set(
                    this.filmes.indexOf(filme),
                        filme);
            else
                throw new NoSuchFieldException(
                    "Filme inexistente.");
        } catch (NoSuchFieldException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public void deletar(int codigo) {
        Filme filme;
        try {
            if ((filme = buscar(codigo)) != null)
                this.filmes.remove(filme);
            else
                throw new NoSuchFieldException(
                    "Filme inexistente.");
        } catch (NoSuchFieldException erro) {
            System.out.println(erro.getMessage());
        }
    }

    public Filme[] listar() {
        try {
            if (this.filmes.isEmpty() == false) {
                Filme filmesArray[] =
                    new Filme[this.filmes.size()];
                return this.filmes.toArray(filmesArray);
            } else
                throw new ArrayIndexOutOfBoundsException(
                    "Nenhum filme cadastrado.");
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println(erro.getMessage());
        }

        return null;
    }
}
