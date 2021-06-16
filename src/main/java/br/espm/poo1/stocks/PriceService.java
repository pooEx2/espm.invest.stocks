package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private StocksService stocksService;

    public List<Price> listAll() {
        return StreamSupport
                .stream(priceRepository.findAll().spliterator(),false)
                .collect(Collectors.toList())
                .stream().map(PriceModel::to)
                .collect(Collectors.toList());
    }

    public Price findById(String id) {
        return fill(
                priceRepository
                    .findById(id.toString())
                    .map(PriceModel::to)
                    .orElse(null)
        );
    }

    public Price findBy(String idStocks, Date date) {
        Price price = priceRepository
                .listByPriceData(idStocks, date).stream()
                .map(PriceModel::to)
                .findFirst()
                .orElse(null);
        return fill(price);
    }

    private Price fill(Price p) {
        if (p != null) {
            p.setStocks(stocksService.findById(UUID.fromString(p.getStocks().getId())));
        }
        return p;
    }
}
