package com.company.itk.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Operarion implements EnumClass<String> {

    IN("In"),
    OUT("Out"),
    FORECAST("Forecast");

    private String id;

    Operarion(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Operarion fromId(String id) {
        for (Operarion at : Operarion.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}