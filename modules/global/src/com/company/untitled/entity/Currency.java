package com.company.untitled.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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