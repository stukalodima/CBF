package com.company.untitled.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "UNTITLED_CURRENCY_RATE")
@Entity(name = "untitled_CurrencyRate")
public class CurrencyRate extends StandardEntity {
    private static final long serialVersionUID = 9112633409936956795L;

    @Column(name = "ON_DATE")
    @NotNull
    private LocalDate onDate;

    @Column(name = "VALUE_")
    @NotNull
    private Double value;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }
}