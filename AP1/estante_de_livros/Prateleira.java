import java.util.Vector;

public class Prateleira {
        private int tamanhoMaximo;
        private Vector<Livro> livros = new Vector<Livro>();

        public Prateleira(int tamanho) {
                this.tamanhoMaximo = tamanho;
        }

        private int espacoLivre() {
                return this.tamanhoMaximo - this.livros.size();
        }

        public boolean adicionarLivro(Livro livro) {
                if (espacoLivre() < 0)
                        return false;
                return this.livros.add(livro);
        }

        public boolean removerLivro(String isbn) {
                Livro livro = this.livros.get(0);
                for (int i = 0; i < this.livros.size(); i++) {
                        livro = this.livros.get(i);
                        if (!(isbn.equals(livro.getISBN())))
                                return false;
                        else
                                break;
                }
                return this.livros.remove(livro);
        }

        public Livro selecionarLivro(String isbn) {
                int posicao = 0;
                for (/* posicao definida acima */; posicao < this.livros.size(); posicao++)
                        if (isbn.equals(this.livros.get(posicao).getISBN()))
                                return this.livros.get(posicao);
                return null;
        }

        public void imprimirLivros() {
                for (int i = 0; i < this.livros.size(); i++)
                        System.out.println(this.livros.get(i).descricao());
        }
}