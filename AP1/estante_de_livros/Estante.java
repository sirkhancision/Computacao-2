import java.util.Vector;

public class Estante {
        private Vector<Prateleira> prateleiras;

        public Estante() {
                int tamanho = 50;
                prateleiras = new Vector<Prateleira>(tamanho);
        }

        public void adicionarPrateleira(Prateleira prateleira) {
                this.prateleiras.add(prateleira);
        }

        public boolean adicionarLivro(Livro livro) {
                boolean estado = false;
                for (int i = 0; i < this.prateleiras.size(); i++) {
                        if (this.prateleiras.get(i).adicionarLivro(livro) == false)
                                continue;
                        else
                                estado = true;
                }
                return estado;
        }

        public boolean removerLivro(Livro livro) {
                boolean estado = false;
                for (int i = 0; i < this.prateleiras.size(); i++) {
                        if (this.prateleiras.get(i).removerLivro(livro.getISBN()) == false)
                                continue;
                        else
                                estado = true;
                }
                return estado;
        }

        public Livro selecionarLivro(String isbn) {
                for (int i = 0; i < this.prateleiras.size(); i++) {
                        if (this.prateleiras.get(i).selecionarLivro(isbn) == null)
                                continue;
                        else
                                return this.prateleiras.get(i).selecionarLivro(isbn);
                }
                return null;
        }

        public void imprimirLivros() {
                for (int i = 0; i < this.prateleiras.size(); i++)
                        this.prateleiras.get(i).imprimirLivros();
        }
}