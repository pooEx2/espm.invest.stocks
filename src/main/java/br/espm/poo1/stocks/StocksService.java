package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StocksService {

    @Autowired
    private StocksRepository stocksRepository;

    public List<Stocks> listBy(String idStock, String symbolStock, String nameStock, Date dateTime, BigDecimal valueStock) {
        return stocksRepository
                .listBy(idStock, symbolStock, nameStock, dateTime, valueStock).stream()
                .map(StocksModel::to)
                .collect(Collectors.toList());
    }

}
