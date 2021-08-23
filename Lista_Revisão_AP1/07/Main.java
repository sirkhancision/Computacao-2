public class Main {
        public static void main(String args[]) {
                // Criando o bloco de notas com um proprietário e mudando-o depois
                BlocoDeNotas bloco = new BlocoDeNotas("Anderson");
                System.out.println(bloco.getProprietario());
                bloco.setProprietario("Jorge");
                System.out.println(bloco.getProprietario());
                // Adicionar uma nota e exibi-la
                bloco.adicionarNota("Teste");
                bloco.exibirNota(0);
                // Adiciona outra nota e exibe todas elas
                bloco.adicionarNota("Teste número 2");
                bloco.imprimirNotas();
                // Mostra numero total de notas antes e após remover uma
                System.out.println(bloco.numeroDeNotas());
                bloco.removerNota(1);
                System.out.println(bloco.numeroDeNotas());
        }
}