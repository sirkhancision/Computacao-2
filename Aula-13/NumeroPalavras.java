import java.lang.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Exercício 03
/* Programa com a função de informar o
número de vezes que uma mesma palavra
aparece em uma dada frase */
public class NumeroPalavras {
	public static void main(String args[]) {
		Map<String, Integer> palavrasMapa = new HashMap<>();
		List<String> palavrasLista = new ArrayList<>();
		List<Character> c = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a frase a ser analisada:");
		String linha = input.nextLine();

		/* Faz uma busca por espaços vazios na string,
		que (provavelmente) significam novas palavras,
		e as salvam como elementos de string em uma lista. */
		for (int i = 0; i < linha.length(); i++) {
			c.add(linha.charAt(i));
			if (linha.charAt(i) == ' ' ||
			(i + 1) == linha.length()) {
				palavrasLista.add(String.valueOf(c)
				.replace(" ", "").replaceAll(",", "")
				.replace("[", "").replace("]", ""));
				palavrasLista.remove("[]"); // remove espaços adicionais
				c.clear();
				continue;
			}
		}
		input.close();

		/* Checa cada ocorrência de uma palavra,
		que é elemento da lista, e caso seja nova,
		atribui o valor 1 no mapa, e caso seja repetida,
		incrementa esse valor */
		for (String palavra : palavrasLista) {
			if (palavrasMapa.containsKey(palavra))
				palavrasMapa.put(palavra,
					palavrasMapa.get(palavra) + 1);
			else
				palavrasMapa.put(palavra, 1);
		}

		/* Imprime cada palavra em uma linha, com
		o seu número de ocorrências */
		for (Map.Entry<String, Integer> entrada :
		palavrasMapa.entrySet()) {
			System.out.println(entrada.getKey() + ": "
			+ entrada.getValue());
		}
	}
}