package ua.bank.dao;

import ua.bank.entity.Currency;
import ua.bank.entity.CurrencyRate;

import java.util.List;

public abstract interface CurrencyDao {
    List<CurrencyRate> getRates();
    Integer getRate(Currency currency);

    void setRate(CurrencyRate rate);
}
