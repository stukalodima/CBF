package com.company.itk.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@Table(name = "UNTITLED_FORECAST_CURRENCY_BALANCE")
@Entity(name = "untitled_ForecastCurrencyBalance")
public class ForecastCurrencyBalance extends StandardEntity {
    private static final long serialVersionUID = 5838031289318463073L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "IN_SUMM1")
    private Double inSumm1;

    @Column(name = "IN_SUMM2")
    private Double inSumm2;

    @Column(name = "IN_SUMM3")
    private Double inSumm3;

    @Column(name = "IN_SUMM4")
    private Double inSumm4;

    @Column(name = "IN_SUMM5")
    private Double inSumm5;

    @Column(name = "OUT_SUMM1")
    private Double outSumm1;

    @Column(name = "OUT_SUMM2")
    private Double outSumm2;

    @Column(name = "OUT_SUMM3")
    private Double outSumm3;

    @Column(name = "OUT_SUMM4")
    private Double outSumm4;

    @Column(name = "OUT_SUMM5")
    private Double outSumm5;

    @Column(name = "FORECAST_SUMM1")
    private Double forecastSumm1;

    @Column(name = "FORECAST_SUMM2")
    private Double forecastSumm2;

    @Column(name = "FORECAST_SUMM3")
    private Double forecastSumm3;

    @Column(name = "FORECAST_SUMM4")
    private Double forecastSumm4;

    @Column(name = "FORECAST_SUMM5")
    private Double forecastSumm5;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FORECAST_ID")
    private Forecast forecast;

    public void setInSumm3(Double inSumm3) {
        this.inSumm3 = inSumm3;
    }

    public Double getInSumm3() {
        return inSumm3;
    }

    public Double getForecastSumm5() {
        return forecastSumm5;
    }

    public void setForecastSumm5(Double forecastSumm5) {
        this.forecastSumm5 = forecastSumm5;
    }

    public Double getForecastSumm4() {
        return forecastSumm4;
    }

    public void setForecastSumm4(Double forecastSumm4) {
        this.forecastSumm4 = forecastSumm4;
    }

    public Double getForecastSumm3() {
        return forecastSumm3;
    }

    public void setForecastSumm3(Double forecastSumm3) {
        this.forecastSumm3 = forecastSumm3;
    }

    public Double getForecastSumm2() {
        return forecastSumm2;
    }

    public void setForecastSumm2(Double forecastSumm2) {
        this.forecastSumm2 = forecastSumm2;
    }

    public Double getForecastSumm1() {
        return forecastSumm1;
    }

    public void setForecastSumm1(Double forecastSumm1) {
        this.forecastSumm1 = forecastSumm1;
    }

    public Double getOutSumm5() {
        return outSumm5;
    }

    public void setOutSumm5(Double outSumm5) {
        this.outSumm5 = outSumm5;
    }

    public Double getOutSumm4() {
        return outSumm4;
    }

    public void setOutSumm4(Double outSumm4) {
        this.outSumm4 = outSumm4;
    }

    public Double getOutSumm3() {
        return outSumm3;
    }

    public void setOutSumm3(Double outSumm3) {
        this.outSumm3 = outSumm3;
    }

    public Double getOutSumm2() {
        return outSumm2;
    }

    public void setOutSumm2(Double outSumm2) {
        this.outSumm2 = outSumm2;
    }

    public Double getOutSumm1() {
        return outSumm1;
    }

    public void setOutSumm1(Double outSumm1) {
        this.outSumm1 = outSumm1;
    }

    public Double getInSumm5() {
        return inSumm5;
    }

    public void setInSumm5(Double inSumm5) {
        this.inSumm5 = inSumm5;
    }

    public Double getInSumm4() {
        return inSumm4;
    }

    public void setInSumm4(Double inSumm4) {
        this.inSumm4 = inSumm4;
    }

    public Double getInSumm2() {
        return inSumm2;
    }

    public void setInSumm2(Double inSumm2) {
        this.inSumm2 = inSumm2;
    }

    public Double getInSumm1() {
        return inSumm1;
    }

    public void setInSumm1(Double inSumm1) {
        this.inSumm1 = inSumm1;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}