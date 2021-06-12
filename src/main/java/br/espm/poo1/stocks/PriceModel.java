package br.espm.poo1.stocks;

import br.espm.poo1.stocks.common.datatype.Price;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "price")
public class PriceModel {

    @Id
    @Column(name = "id_price")
    private String idPrice;

    @Column(name = "id_stocks")
    private String idStocks;

    @Column(name = "dt_date")
    private Date dtDate;

    @Column(name = "nr_value")
    private BigDecimal nrValue;

    public PriceModel(Price p) {
        this.idPrice = p.getId();
        this.idStocks = p.getIdStocks();
        this.dtDate = p.getDate();
        this.nrValue = p.getValue();
    }

    public Price to() {
        Price p = new Price();
        p.setId(idPrice);
        p.setIdStocks(idStocks);
        p.setDate(dtDate);
        p.setValue(nrValue);
        return p;

    }
}
