package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatus {
    SINGLE("S"),
    MARIED("M"),
    DIVORDED("D"),
    SEPARATED("P"),
    WIDOWED("W"),
    UNDISCLOSED("U");

    public static final int LENGTH = 1;

    private String value;

    private MaritalStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, MaritalStatus> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static MaritalStatus fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<MaritalStatus, String> {

        @Override
        public String convertToDatabaseColumn(MaritalStatus attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public MaritalStatus convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
