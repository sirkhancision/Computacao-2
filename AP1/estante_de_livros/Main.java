public class Main {
        public static void main(String args[]) {
                Estante estante1 = new Estante();
                Prateleira prateleira = new Prateleira(3);

                estante1.adicionarPrateleira(prateleira);
                estante1.adicionarLivro(new Livro("1234", "Livro de Teste", "Autor Qualquer", 2021, 2, 356, 50));
                estante1.adicionarLivro(new Livro("5678", "Livro de Teste N°2", "Outro Autor Qualquer", 2021, 5, 1337, 124));

                System.out.println(estante1.selecionarLivro("1234").descricao());
                System.out.println(estante1.selecionarLivro("5678").descricao());

                estante1.imprimirLivros();

                estante1.removerLivro(estante1.selecionarLivro("1234"));
                estante1.imprimirLivros();
        }
}