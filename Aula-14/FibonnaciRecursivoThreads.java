import java.util.Scanner;

public class FibonnaciRecursivoThreads extends Thread {
	private int max;
	public int value;

	private FibonnaciRecursivoThreads(int max) {
		this.max = max;
	}

	@Override
	public void run() {
		if (max == 0)
			this.value = max;
		else if (max == 1 || max == 2)
			this.value = 1;
		else if (max > 2) {
			try {
				FibonnaciRecursivoThreads t1 = new FibonnaciRecursivoThreads(max-1);
				FibonnaciRecursivoThreads t2 = new FibonnaciRecursivoThreads(max-2);
				t1.start();
				t2.start();
				t1.join();
				t2.join();
				this.value = t1.value + t2.value;
			}
			catch(InterruptedException | OutOfMemoryError e) {}
		}
	}

	public static void main(String args[]) {
		try {
			int max;
			Scanner input = new Scanner(System.in);

			System.out.println("Digite a posição máxima da série de Fibonacci: ");
			max = input.nextInt();
			FibonnaciRecursivoThreads func = new FibonnaciRecursivoThreads(max);
			func.start();
			func.join();
			
			System.out.println("Fib " + max + ": " + func.value);
			input.close();
		}
		catch(InterruptedException | OutOfMemoryError e) {}
	}
}
