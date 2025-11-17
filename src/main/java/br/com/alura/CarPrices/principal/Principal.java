package br.com.alura.CarPrices.principal;

import br.com.alura.CarPrices.service.ConsumingApi;

import java.util.Scanner;

public class Principal {

    private final String apiEndpoint = "https://fipe.parallelum.com.br/api/v2/";

    private ConsumingApi apiConsuming = new ConsumingApi();

    private Scanner readTerminal = new Scanner(System.in);

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
        String url;

        if (option.toLowerCase().contains("carr")) {
            url = apiEndpoint + "cars/brands";
        } else if (option.toLowerCase().contains("mot")) {
            url = apiEndpoint + "motorcycles/brands";
        } else {
            url = apiEndpoint + "trucks/brands";
        }

        var json = apiConsuming.GetData(url);

    }
}
