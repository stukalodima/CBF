package com.company.itk.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "UNTITLED_COMPANY")
@Entity(name = "untitled_Company")
@NamePattern("%s|name")
public class Company extends StandardEntity {
    private static final long serialVersionUID = 152317555246684163L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EDRPOU", length = 12)
    @NotNull
    private String edrpou;

    @Lookup(type = LookupType.DROPDOWN, actions = {"open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_DIRECTION_ID")
    @NotNull
    private BusinessDirection businessDirection;

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public BusinessDirection getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(BusinessDirection businessDirection) {
        this.businessDirection = businessDirection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}