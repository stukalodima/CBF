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
import java.time.LocalDate;
import java.util.Collection;

@Table(name = "UNTITLED_FORECAST")
@Entity(name = "untitled_Forecast")
public class Forecast extends StandardEntity {
    private static final long serialVersionUID = 9142833072624464486L;

    @Column(name = "POROG")
    @NotNull
    private Double porog;

    @Column(name = "BALANCE_DATE")
    @NotNull
    private LocalDate balanceDate;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "forecast")
    private Collection<ForecastBNBalance> balanceBNTable;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "forecast")
    private Collection<ForecastCompanyBalance> balanceCompanyTable;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "forecast")
    private Collection<ForecastCurrencyBalance> balanceCurrencyTable;

    public Collection<ForecastCompanyBalance> getBalanceCompanyTable() {
        return balanceCompanyTable;
    }

    public void setBalanceCompanyTable(Collection<ForecastCompanyBalance> balanceCompanyTable) {
        this.balanceCompanyTable = balanceCompanyTable;
    }

    public Collection<ForecastBNBalance> getBalanceBNTable() {
        return balanceBNTable;
    }

    public void setBalanceBNTable(Collection<ForecastBNBalance> balanceBNTable) {
        this.balanceBNTable = balanceBNTable;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Collection<ForecastCurrencyBalance> getBalanceCurrencyTable() {
        return balanceCurrencyTable;
    }

    public void setBalanceCurrencyTable(Collection<ForecastCurrencyBalance> balanceCurrencyTable) {
        this.balanceCurrencyTable = balanceCurrencyTable;
    }

    public Double getPorog() {
        return porog;
    }

    public void setPorog(Double porog) {
        this.porog = porog;
    }
}