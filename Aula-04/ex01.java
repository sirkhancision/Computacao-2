/**
Programa para testar operadores booleanos de comparação, e operadores
matemáticos, com os valores 3 e 6
*/

class TestaOperadores {
        public static void main (String args[]) {
                int a = 3, b = 6;

                System.out.println("a = " + a + "; b = " + b);
                        // Imprimir valores
                System.out.println(("a == b: ") + (a == b)); // Igualdade
                System.out.println(("a != b: ") + (a != b)); // Desigualdade
                System.out.println(("a < b: ") + (a < b)); // Menor que
                System.out.println(("a > b: ") + (a > b)); // Maior que
                System.out.println(("a <= b: ") + (a <= b)); // Menor ou igual
                System.out.println(("a >= b: ") + (a >= b)); // Maior ou igual
                System.out.println(("(a == 1) && (b > 1): ") + ((a == 1)
                        && (b > 1))); // AND/E
                System.out.println(("(a == 1) || (b > 1): ") + ((a == 1)
                        || (b > 1))); // OR/OU

                System.out.println("a + b = " + (a + b)); // Adição
                System.out.println("a - b = " + (a - b)); // Subtração
                System.out.println("a * b = " + (a * b)); // Multiplicação
                System.out.println("a / b = " + (a / b)); // Divisão
                System.out.println("a % b = " + (a % b)); // Módulo
                a++;
                b++;
                System.out.println("a++; b++ = " + a + "; " + b); // Incremento
                a--;
                b--;
                System.out.println("a--; b-- = " + a + "; " + b); // Decremento
        }
}
