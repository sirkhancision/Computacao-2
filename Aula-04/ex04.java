import java.util.Scanner;

/**
Método que recebe 2 valores do usuário, e checa/imprime o menor valor
*/
class TernarioIfElse {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o primeiro valor: ");
                short valor1 = scanner.nextShort();
                System.out.println("Digite o segundo valor: ");
                short valor2 = scanner.nextShort();
                short menor = 0;
                if (valor1 < valor2) {
                        menor = valor1;
                } else {
                        menor = valor2;
                }
                System.out.println("Este é o menor valor: " + menor);
        }
}

/**
Método que, dependendo do valor digitado pelo usuário, retorna 3
possíveis strings
*/
class Switch {
        public static void main (String args[]) {
                System.out.println("Digite a opção: ");
                Scanner scanner = new Scanner(System.in);
                int opt = scanner.nextInt();
                switch(opt) {
                        case 1: System.out.println("Opt - 1");
                                break;
                        case 2: System.out.println("Opt - 2");
                                break;
                        default: System.out.println("Erro");
                                break;
                }
        }
}

/**
Método que cria um loop, durando até o usuário digitar o número 5
*/
class Enquanto {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Tecle um numeral: ");
                int opt = scanner.nextInt();
                while (opt != 5) {
                        System.out.println("Tente novamente");
                        System.out.println("Tecle um numeral: ");
                        opt = scanner.nextInt();
                }
                System.out.println("Acertou!!!");
        }
}

/**
Método que cria um loop, durando até o usuário digitar o número 5, implementado
com o uso do "do while"
*/
class FacaEnquanto {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                int opt = 0;
                do {
                        System.out.println("Tecle um numeral: ");
                        opt = scanner.nextInt();
                } while (opt != 5);
                System.out.println("Acertou!!!");
        }
}

/**
Método com loop recursivo onde, após ser dado um limite máximo, imprime números
de 0 ao limite - 1
*/
class Para {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite o máximo: ");
                int max = scanner.nextInt();
                for (int i = 0; i < max; i++) {
                        System.out.println("Número " + i);
                }
        }
}

/**
Método com loop recursivo onde, após ser dado um limite máximo, imprime números
de 0 à metade truncada do limite, indicando explicitamente o valor da última
iteração
*/
class Break {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite um número: ");
                int max = scanner.nextInt();
                int i = 0;
                for (i = 0; i < max; i++) {
                        if (i == (max/2)) {
                                break; // sai do for
                        }
                        System.out.println("for: i = " + i);
                }
                System.out.println("for final: i = " + i);
        }
}

/**
Método com loop recursivo onde, após ser dado um limite máximo, imprime números
de 0 ao limite
*/
class Continue {
        public static void main (String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Digite um número: ");
                int max = scanner.nextInt();
                int i = 0;
                for (i = 0; i < max; i++) {
                        if (i == 7) {
                                continue; // retorna ao for 1
                        }
                        System.out.println("for: i = " + i);
                }
                System.out.println("for final: i = " + i);
        }
}
