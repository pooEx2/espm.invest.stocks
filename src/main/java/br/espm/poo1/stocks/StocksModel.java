package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Stocks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class StocksModel {

    @Id
    @Column(name = "id_stocks")
    private String idStocks;

    @Column(name = "txt_symbol")
    private String symbolStocks;

    @Column(name = "txt_name")
    private String nameStocks;

    public StocksModel(Stocks c) {
        this.idStocks = c.getId();
        this.symbolStocks = c.getSymbol();
        this.nameStocks = c.getName();
    }

    public Stocks to() {
        Stocks s = new Stocks();
        s.setId(idStocks);
        s.setSymbol(symbolStocks);
        s.setName(nameStocks);
        return s;

    }

}


