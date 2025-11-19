package br.com.alura.CarPrices.principal;

import br.com.alura.CarPrices.model.BaseData;
import br.com.alura.CarPrices.model.Model;
import br.com.alura.CarPrices.service.ConsumingApi;
import br.com.alura.CarPrices.service.DataConversion;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private final String apiEndpoint = "https://fipe.parallelum.com.br/api/v2/";
    private ConsumingApi apiConsuming = new ConsumingApi();
    private Scanner readTerminal = new Scanner(System.in);
    private DataConversion conversor = new DataConversion();

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

        var marcas = conversor.getList(json, BaseData.class);

        marcas.stream()
                .sorted(Comparator.comparing(BaseData::code))
                .forEach(x -> System.out.println("nome da marca = " + x.name() + "; Código da Marca = " + x.code()));

        System.out.println("Informe o código da marca para consulta: ");
        var brandCode = readTerminal.nextLine();

        url = url + "/" + brandCode + "/models";
        json = apiConsuming.GetData(url);
        var modelList = conversor.getData(json, Model.class);

        System.out.println("modelos de carros");
        modelList.models().stream()
                .sorted(Comparator.comparing(BaseData::code))
                .forEach(System.out::println);

    }
}
