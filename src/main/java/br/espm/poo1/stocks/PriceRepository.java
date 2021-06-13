package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Price;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PriceRepository extends CrudRepository<PriceModel, String> {

    @Override
    Iterable<PriceModel> findAll();

    @Override
    Optional<PriceModel> findById(String s);


}
