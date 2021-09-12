import java.util.Scanner;

public class FibonnaciRecursivo {
	private static int FibFuncao(int max) {
		return max == 0 ? max : max == 1 || max == 2 ? 1 :
			FibFuncao(max-1) + FibFuncao(max-2);
	}

	public static void main(String args[]) {
		int max;
		Scanner input = new Scanner(System.in);

		System.out.println("Digite a posição máxima da série de Fibonacci: ");
		max = input.nextInt();
		
		System.out.println("Fib " + max + ": " + FibFuncao(max));
		input.close();
	}
}
