package sisloc.filme;
import java.util.ArrayList;

public class RepositorioFilme implements IRepositorioFilme {
    private ArrayList<Filme> filmes = new ArrayList<Filme>();

    public void cadastrar(Filme filme) {
        try {
            buscar(filme.getCodigo());
            throw new IllegalArgumentException(
                "Filme já cadastrado.\n");
        } catch(ArrayIndexOutOfBoundsException erro) {
            this.filmes.add(filme);
        }
    }

    public Filme buscar(int codigo) {
        for (Filme filme : this.filmes)
            if (filme.getCodigo() == codigo)
                return filme;
        
        throw new ArrayIndexOutOfBoundsException("Filme não cadastrado.\n");
    }
    
    public void atualizar(Filme filme) {
        this.filmes.set(this.filmes.indexOf(buscar(filme.getCodigo())),
            filme);
    }

    public void deletar(int codigo) {
        Filme filme = buscar(codigo);

        this.filmes.remove(filme);
    }

    public Filme[] listar() {
        if (this.filmes.isEmpty() == false) {
            Filme filmesArray[] =
                new Filme[this.filmes.size()];
            return this.filmes.toArray(filmesArray);
        } else
            throw new ArrayIndexOutOfBoundsException(
                "Nenhum filme cadastrado.\n");
    }
}
