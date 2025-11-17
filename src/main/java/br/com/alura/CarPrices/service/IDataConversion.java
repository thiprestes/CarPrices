package br.com.alura.CarPrices.service;

import java.util.List;

public interface IDataConversion {
    <T> T getData(String json, Class<T> classe);
    <T> List<T> getList(String json, Class<T> classe);
}
