package processoseletivo;

import java.util.Scanner;

public class Atividade5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] c = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            stringBuilder.append(c[i]);
        }
        System.out.println("A String invertida é:\n" + stringBuilder);
    }
}
