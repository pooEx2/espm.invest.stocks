package br.espm.poo1.stocks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StocksRepository extends CrudRepository<StocksModel, String> {

    @Override
    Iterable<StocksModel> findAll();

    @Override
    Optional<StocksModel> findById(String s);

    Optional<StocksModel> findBySymbol(String symbol);

    @Query("SELECT s from StocksModel s WHERE s.idStocks = :idStocks AND s.symbolStocks = :symbolStocks AND s.nameStocks = :nameStocks")
    List<StocksModel> listByStocksData (
            @Param("idStocks") String idStocks,
            @Param("symbolStocks") String symbolStocks,
            @Param("nameStocks") String nameStocks
    );

    List<StocksModel> listBy(
            @Param("idStocks") String idStocks,
            @Param("symbolStocks") String symbolStocks,
            @Param("nameStocks") String nameStocks
    );
}
