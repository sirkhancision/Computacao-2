import java.util.ArrayList;

public class BlocoDeNotas {
        private String proprietario;
        private ArrayList<Nota> notas;

        public BlocoDeNotas() {
                this.proprietario = "Zé ninguém";
                this.notas = new ArrayList<Nota>();
        }

        public BlocoDeNotas(String proprietario) {
                this.proprietario = proprietario;
                this.notas = new ArrayList<Nota>();
        }

        public void setProprietario(String proprietario) {
                this.proprietario = proprietario;
        }

        public String getProprietario() {
                return this.proprietario;
        }

        public boolean adicionarNota(String nota) {
                return this.notas.add(new Nota(nota));
        }

        public int numeroDeNotas() {
                return this.notas.size();
        }

        public void imprimirNotas() {
                for (int i = 0; i < this.notas.size(); i++) {
                        Nota nota = this.notas.get(i);
                        nota.descricaoDetalhada();
                }
        }

        public void exibirNota(int posicao) {
                Nota nota = this.notas.get(posicao);
                nota.descricaoDetalhada();
        }

        public void removerNota(int posicao) {
                this.notas.remove(posicao);
        }
}