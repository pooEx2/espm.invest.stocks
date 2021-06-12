package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class StocksService {

    @Autowired
    private StocksRepository stocksRepository;

    public List<Stocks> listAll() {
        return StreamSupport
                .stream(stocksRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(StocksModel::to)
                .collect(Collectors.toList());
    }

    public Stocks findById(UUID id) {
        return stocksRepository
                .findById(id.toString())
                .map(StocksModel::to)
                .orElse(null);
    }

    public Stocks findBySymbol(String symbol) {
        return stocksRepository
                .findBySymbol(symbol)
                .map(StocksModel::to)
                .orElse(null);
    }

}
