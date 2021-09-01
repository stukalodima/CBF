package com.company.itk.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Table(name = "UNTITLED_CURRENCY")
@Entity(name = "untitled_Currency")
@NamePattern("%s|name")
public class Currency extends StandardEntity {
    private static final long serialVersionUID = 1940176179098299761L;

    @Column(name = "NAME")
    @NotNull
    private String name;

    @Column(name = "BASE_")
    private Boolean base;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "currency")
    private Collection<CurrencyRate> currencyRateDetail;

    public Collection<CurrencyRate> getCurrencyRateDetail() {
        return currencyRateDetail;
    }

    public void setCurrencyRateDetail(Collection<CurrencyRate> currencyRateDetail) {
        this.currencyRateDetail = currencyRateDetail;
    }

    public Boolean getBase() {
        return base;
    }

    public void setBase(Boolean base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}