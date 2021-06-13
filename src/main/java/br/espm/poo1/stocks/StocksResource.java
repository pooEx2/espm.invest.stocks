package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.controller.StocksController;
import br.espm.poo1.stocks.common.datatype.Price;
import br.espm.poo1.stocks.common.datatype.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@EnableFeignClients(basePackages = "br.espm.poo1.stocks.common.controller")
@RestController
public class StocksResource implements StocksController{

    @Autowired
    private StocksService stocksService;
    private PriceService priceService;

    @Override
    public List<Price> prices() {
        return priceService.listAll();
    }

    @Override
    public Price price(String id) {
        return priceService.findById(UUID.fromString(id));
    }

    @Override
    public List<Stocks> stocks() {
        return stocksService.listAll();
    }


    @Override
    public Stocks stocks(String symbol) {
        return stocksService.findBySymbol(symbol);
    }

    @Override
    public Stocks stocks(String symbol, String date) {
        return null;
    }
}
