package PDV;

import java.util.Scanner;

public class PDV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        Produto p1 = new Produto(entrada, 10.0);

        System.out.println(p1.Nome);

    }
}
