package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Stocks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "stocks")
public class StocksModel {

    @Id
    @Column(name = "id_stocks")
    private String idStocks;

    @Column(name = "symbol_stocks")
    private String symbolStocks;

    @Column(name = "name_stocks")
    private String nameStocks;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "value_stocks")
    private BigDecimal valueStocks;

    public StocksModel(Stocks c) {
        this.idStocks = c.getId();
        this.symbolStocks = c.getSymbol();
        this.nameStocks = c.getName();
        this.dateTime = c.getDate();
        this.valueStocks = c.getValue();
    }

    public Stocks to() {
        Stocks s = new Stocks();
        s.setId(idStocks);
        s.setSymbol(symbolStocks);
        s.setName(nameStocks);
        s.setDate(dateTime);
        s.setValue(valueStocks);
        return s;

    }

}


