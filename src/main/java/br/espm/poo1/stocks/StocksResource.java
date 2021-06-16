package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.controller.StocksController;
import br.espm.poo1.stocks.common.datatype.Price;
import br.espm.poo1.stocks.common.datatype.Stocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@EnableFeignClients(basePackages = "br.espm.poo1.stocks.common.controller")
@RestController
public class StocksResource implements StocksController{

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private StocksService stocksService;
    @Autowired
    private PriceService priceService;

    @Override
    public List<Stocks> stocks() {
        return stocksService.listAll();
    }

    @Override
    public Stocks stocks(@PathVariable String symbol) {
        return stocksService.findBySymbol(symbol);
    }

    @Override
    public List<Price> prices() {
        return priceService.listAll();
    }

    @Override
    public Price price(@PathVariable String id) {
        return priceService.findById(id);
    }

    @Override
    public Price price(@PathVariable String idStocks, @PathVariable String date) {
        try {
            return priceService.findBy(idStocks, sdf.parse(date));
        } catch (
        ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Stocks> stocks(
            @PathVariable String id,
            @PathVariable String symbol,
            @PathVariable String name) {
        return null;
    }
}
