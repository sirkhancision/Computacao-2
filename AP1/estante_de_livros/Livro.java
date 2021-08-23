public class Livro {
        private String isbn; // Código ISBN
        private String titulo; // Título do livro
        private String autor; // Nome do autor
        private int ano; // Ano de publicação
        private int edicao; // Número da edição
        private int paginas; // Número de páginas
        private int espessura; // Espessura do livro (cm)

        public Livro(String isbn, String titulo, String autor, int ano, int edicao, int paginas, int espessura) {
                this.isbn = isbn;
                this.titulo = titulo;
                this.autor = autor;
                this.ano = ano;
                this.edicao = edicao;
                this.paginas = paginas;
                this.espessura = espessura;
        }

        public String getISBN() {
                return isbn;
        }

        public String getTitulo() {
                return titulo;
        }

        public String getAutor() {
                return autor;
        }

        public int getAno() {
                return ano;
        }

        public int getEdicao() {
                return edicao;
        }

        public int getPaginas() {
                return paginas;
        }

        public int getEspessura() {
                return espessura;
        }

        // Retorna detalhes do livro
        public String descricao() {
                String descricao = new String();
                descricao = "ISBN: " + isbn + " | Livro: " + titulo + " | Autor: " + autor + " | Ano: " + ano + " | Edição: " + edicao + " | Páginas: " + paginas+ " | Espessura: " + espessura + "cm.";
                return descricao;
        }
}