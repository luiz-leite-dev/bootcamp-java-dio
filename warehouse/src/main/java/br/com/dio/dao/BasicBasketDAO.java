package br.com.dio.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.dio.model.BasicBasket;
import br.com.dio.model.StockInfo;

public class BasicBasketDAO {

    private List<BasicBasket> stock = new ArrayList<>();

    public List<BasicBasket> addBatch(final List<BasicBasket> baskets) {
        stock.addAll(baskets);
        return baskets;
    }

    public List<BasicBasket> remove(final int amount) {
        stock.sort(Comparator.comparing(BasicBasket::price));
        var toRemove = stock.subList(0, amount);
        stock = stock.subList(amount, stock.size());
        return toRemove;
    }

    public StockInfo getInfo() {
        return new StockInfo(stock.size(), stock.stream().filter(b -> b.validate().isBefore(LocalDate.now())).count());
    }

    public List<BasicBasket> removeOutOfDate() {
        var outOfDate = stock.stream().filter(b -> b.validate().isBefore(LocalDate.now())).toList();
        stock.removeAll(outOfDate);
        return outOfDate;
    }

}
