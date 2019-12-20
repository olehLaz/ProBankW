package ua.bank.entity;


import javax.persistence.*;

@Entity
@Table(name = "currencyRates_tab")
public class CurrencyRate {

    @Id
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false)
    private Integer rate;

    public CurrencyRate() {
    }

    public CurrencyRate(Currency currency, Integer rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Integer getRate() {
        return rate;
    }
}
