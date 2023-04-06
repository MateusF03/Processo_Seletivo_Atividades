package processoseletivo;

import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        long value = sc.nextLong();
        System.out.println("O número " + value + " está na sequência de fibbonaci?: " + isInFib(value));
    }

    private static boolean isInFib(long value) {
        long fib1 = 0;
        long fib2 = 1;
        if (value == fib1 || value == fib2) {
            return true;
        }
        long aux = fib1 + fib2;
        while (aux <= value) {
            if (aux == value)
                return true;
            fib1 = fib2;
            fib2 = aux;
            aux = fib1 + fib2;
        }
        return false;
    }
}
