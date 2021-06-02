package com.company.untitled.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "UNTITLED_BUSINESS_DIRECTION")
@Entity(name = "untitled_BusinessDirection")
@NamePattern("%s|name")
public class BusinessDirection extends StandardEntity {
    private static final long serialVersionUID = -2102117402289817776L;

    @Column(name = "NAME")
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}