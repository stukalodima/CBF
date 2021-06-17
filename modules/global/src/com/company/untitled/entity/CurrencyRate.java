package com.company.untitled.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    private Double value;

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