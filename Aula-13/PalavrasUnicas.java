import java.lang.Character;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Exercício 02
/* Programa com a função de informar o número
de palavras únicas/não repetidas
de uma dada frase */
public class PalavrasUnicas {
	public static void main(String args[]) {
		Set<String> palavras = new HashSet<>();
		List<Character> c = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a frase a ser analisada:");
		String linha = input.nextLine();

		/* Faz uma busca por espaços vazios na string,
		que (provavelmente) significam novas palavras,
		e as salvam como elementos de string na lista. */
		for (int i = 0; i < linha.length(); i++) {
			c.add(linha.charAt(i));
			if (linha.charAt(i) == ' ' ||
			(i + 1) == linha.length()) {
				palavras.add(String.valueOf(c)
				.replaceAll(" ", "").replaceAll(",", ""));
				palavras.remove("[]"); // remove espaços adicionais
				c.clear();
				continue;
			}
		}
		input.close();

		System.out.println("Número de palavras únicas: "
		+ palavras.size());
	}
}