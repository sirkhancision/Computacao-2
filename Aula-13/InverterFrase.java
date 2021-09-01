import java.lang.Character;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercício 01
/* O programa deve inverter a ordem das palavras
na frase que for dada */
public class InverterFrase {
	public static void main(String args[]) {
		List<String> frase = new ArrayList<>();
		List<Character> c = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a frase a ser invertida:");
		String linha = input.nextLine();

		/* Faz uma busca por espaços vazios na string,
		que (provavelmente) significam novas palavras,
		e as salvam como elementos de string na lista */
		for (int i = 0; i < linha.length(); i++) {
			c.add(linha.charAt(i));
			if (linha.charAt(i) == ' ' ||
			(i + 1) == linha.length()) {
				frase.add(String.valueOf(c).replace(" ", "")
				.replace("[", "").replace("]", "")
				.replaceAll(",", ""));
				c.clear();
				continue;
			}
		}
		input.close();

		/* Inicia a iteração pelo ultimo elemento da lista,
		terminando no primeiro.
		Problema com essa implementação:
		caso a frase possua vírgula, ela some
		porém, para uso exclusivo com lista, é a melhor forma
		que encontrei até então de lidar com os colchetes de vírgula
		do ArrayList */
		for (int i = frase.size(); i-- > 0; )
			System.out.print(frase.get(i) + " ");
		System.out.print('\n');
	}
}