package com.company.untitled.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CashType implements EnumClass<Integer> {

    ACC(0),
    CASH(1);

    private Integer id;

    CashType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static CashType fromId(Integer id) {
        for (CashType at : CashType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}