package com.company.untitled.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Table(name = "UNTITLED_FORECAST")
@Entity(name = "untitled_Forecast")
public class Forecast extends StandardEntity {
    private static final long serialVersionUID = 9142833072624464486L;

    @Column(name = "POROG")
    @NotNull
    private Double porog;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "forecast")
    private Collection<ForecastCurrencyBalance> balanceCurrencyTable;

    @Column(name = "BALANCE_IN_BASE_CURRENCY")
    private Double balanceInBaseCurrency;

    public Collection<ForecastCurrencyBalance> getBalanceCurrencyTable() {
        return balanceCurrencyTable;
    }

    public void setBalanceCurrencyTable(Collection<ForecastCurrencyBalance> balanceCurrencyTable) {
        this.balanceCurrencyTable = balanceCurrencyTable;
    }

    public Double getBalanceInBaseCurrency() {
        return balanceInBaseCurrency;
    }

    public void setBalanceInBaseCurrency(Double balanceInBaseCurrency) {
        this.balanceInBaseCurrency = balanceInBaseCurrency;
    }

    public Double getPorog() {
        return porog;
    }

    public void setPorog(Double porog) {
        this.porog = porog;
    }
}