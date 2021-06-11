package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StocksService {

    @Autowired
    private StocksRepository stocksRepository;

    public Stocks findById(String id) {
        return fill(
                stocksRepository
                        .findById(id)
                        .map(StocksModel::to)
                        .orElse(null)
        );
    }

    private Stocks fill(Stocks c) {
        if (c != null) {

        }
        return c;
    }

}
