package br.com.alura.CarPrices.principal;

import java.util.Scanner;

public class Principal {
    private Scanner readTerminal = new Scanner(System.in);
    private final apiEndpoint = "https://fipe.parallelum.com.br/api/v2";

    public void showMenu() {
        var menu = """
                *** Opções ***
                Carro
                Moto
                Caminhão
                
                Digite uma das opções acima!
                """;
        System.out.println(menu);

        var option = readTerminal.nextLine();



    }
}
