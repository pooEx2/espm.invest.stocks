package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public List<Price> listAll() {
        return StreamSupport
                .stream(priceRepository.findAll().spliterator(),false)
                .collect(Collectors.toList())
                .stream().map(PriceModel::to)
                .collect(Collectors.toList());
    }

    public Price findById(UUID id) {
        return priceRepository
                .findById(id.toString())
                .map(PriceModel::to)
                .orElse(null);
    }
}
