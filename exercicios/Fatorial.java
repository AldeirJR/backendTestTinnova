import java.util.Scanner;

public class Fatorial {

    /**
     * Retorna a soma de todos os números naturais abaixo de x
     * que sejam múltiplos de 3 ou 5.
     */
    public static int sumOfMultiples(int x) {
        int soma = 0;
        for (int i = 1; i < x; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int x = sc.nextInt();

        sc.close();

        int resultado = sumOfMultiples(x);
        System.out.println("A soma dos múltiplos de 3 ou 5 abaixo de " + x + " é: " + resultado);
    }
}
