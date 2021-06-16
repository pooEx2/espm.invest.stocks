package br.espm.poo1.stocks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public interface PriceRepository extends CrudRepository<PriceModel, String> {

    @Override
    Iterable<PriceModel> findAll();

    @Override
    Optional<PriceModel> findById(String id);

    @Query("SELECT p from PriceModel p " +
            "WHERE " +
            "(p.idStocks is null or p.idStocks = :idStocks) AND " +
            "(p.dtDate is null or p.dtDate >= :dtDate)"
    )
    List<PriceModel> listByPriceData (
            @Param("idStocks") String idStocks,
            @Param("dtDate") Date dtDate
    );

    /*List<StocksModel> listBy(
            @Param("idStocks") String idStocks,
            @Param("symbolStocks") String symbolStocks,
            @Param("nameStocks") String nameStocks
    );*/
}
