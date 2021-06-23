package com.company.untitled.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@Table(name = "UNTITLED_FORECAST_COMPANY")
@Entity(name = "untitled_ForecastCompany")
public class ForecastCompany extends StandardEntity {
    private static final long serialVersionUID = 2853797795412443555L;

    @Column(name = "ROW_")
    private Integer row;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @Column(name = "TYPE_CASH")
    private Integer typeCash;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "DAY_")
    private Integer day;

    @Column(name = "OPERATION")
    private String operation;

    @Column(name = "SUMM")
    private Double summ;

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    public Operarion getOperation() {
        return operation == null ? null : Operarion.fromId(operation);
    }

    public void setOperation(Operarion operation) {
        this.operation = operation == null ? null : operation.getId();
    }

    public Day getDay() {
        return day == null ? null : Day.fromId(day);
    }

    public void setDay(Day day) {
        this.day = day == null ? null : day.getId();
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CashType getTypeCash() {
        return typeCash == null ? null : CashType.fromId(typeCash);
    }

    public void setTypeCash(CashType typeCash) {
        this.typeCash = typeCash == null ? null : typeCash.getId();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}