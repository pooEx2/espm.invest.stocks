package br.espm.poo1.stocks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends CrudRepository<PriceModel, String> {

    @Override
    Iterable<PriceModel> findAll();

    @Override
    Optional<PriceModel> findById(String s);


}
