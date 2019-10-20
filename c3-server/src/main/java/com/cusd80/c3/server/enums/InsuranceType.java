package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InsuranceType {
    EMPLOYER("E"),
    PRIVATE("P"),
    AHCCCS("A"),
    INDIAN_HEALTH_SERVICES("I"),
    MILITARY("M"),
    NONE("N"),
    OTHER("O");

    public static final int LENGTH = 1;

    private String value;

    private InsuranceType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, InsuranceType> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static InsuranceType fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<InsuranceType, String> {

        @Override
        public String convertToDatabaseColumn(InsuranceType attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public InsuranceType convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
