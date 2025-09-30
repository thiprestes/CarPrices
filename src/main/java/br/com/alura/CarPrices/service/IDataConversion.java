package br.com.alura.CarPrices.service;

public interface IDataConversion {
    <T> T GetData(String json, Class<T> classe);
}
