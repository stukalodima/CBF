package com.company.itk.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Day implements EnumClass<Integer> {

    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5);

    private Integer id;

    Day(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static Day fromId(Integer id) {
        for (Day at : Day.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}