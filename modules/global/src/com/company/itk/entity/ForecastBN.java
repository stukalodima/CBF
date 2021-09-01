package com.company.itk.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;

@Table(name = "UNTITLED_FORECAST_BN")
@Entity(name = "untitled_ForecastBN")
@NamePattern("%s от %s|businessDirection,balanceDate")
public class ForecastBN extends StandardEntity {
    private static final long serialVersionUID = 2381900816465363785L;

    @Lookup(type = LookupType.DROPDOWN, actions = "open")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_DIRECTION_ID")
    @NotNull
    private BusinessDirection businessDirection;

    @Column(name = "BALANCE_DATE")
    @NotNull
    private LocalDate balanceDate;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "forecastBN")
    private Collection<ForecastBNDetail> forecastDetail;

    @Column(name = "ACTIVE")
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setForecastDetail(Collection<ForecastBNDetail> forecastDetail) {
        this.forecastDetail = forecastDetail;
    }

    public Collection<ForecastBNDetail> getForecastDetail() {
        return forecastDetail;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public BusinessDirection getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(BusinessDirection businessDirection) {
        this.businessDirection = businessDirection;
    }
}