package br.espm.poo1.stocks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface StocksRepository extends CrudRepository<StocksModel, String> {

    @Override
    Iterable<StocksModel> findAll();

    @Override
    Optional<StocksModel> findById(String s);

    @Query("SELECT s FROM StocksModel s WHERE UPPER(s.symbolStocks) = UPPER(:symbol)")
    Optional<StocksModel> findBySymbol(@Param("symbol") String symbol);
}
