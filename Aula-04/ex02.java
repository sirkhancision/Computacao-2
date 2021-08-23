/**
Programa para testar operadores binários, com os valores 3 e 6
*/

class TestaOperadorBinario {
        public static void main (String args[]) {
                int a = 3, b = 6;

                System.out.println("a = " + a + "; b = " + b);
                        // Imprimir valores
                System.out.println(("~a: ") + ~a); // Complemento binário
                System.out.println(("a = a & 0x22: ") + (a = a & 0x22));
                        // AND/E
                System.out.println(("a = a | b: ") + (a = a | b)); // OR/OU
                System.out.println(("a = a ^ b: ") + (a = a ^ b));
                        // XOR/OU exclusivo
                System.out.println(("a = 2 >> a: ") + (a = 2 >> a));
                        // Deslocamento à esquerda
                System.out.println(("a = a << 2: ") + (a = a << 2));
                        // Deslocamento à direita
        }
}
