package br.espm.poo1.stocks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface StocksRepository extends CrudRepository<StocksModel, String> {

    @Override
    Iterable<StocksModel> findAll();

    @Override
    Optional<StocksModel> findById(String s);

    @Query("Select c from StocksModel c WHERE c.idStocks = :idStocks AND c.dateTime <= :data ORDER BY c.dateTime DESC")
    List<StocksModel> listByStocksData (
            @Param("idStocks") String idStocks,
            @Param("symbolStocks") String symbolStocks,
            @Param("nameStocks") String nameStocks,
            @Param("dateTime") Date dateTime,
            @Param("valueStocks") BigDecimal valueStocks
    );

    List<StocksModel> listBy(
            @Param("idStocks") String idStocks,
            @Param("symbolStocks") String symbolStocks,
            @Param("nameStocks") String nameStocks,
            @Param("dateTime") Date dateTime,
            @Param("valueStocks") BigDecimal valueStocks
    );
}
