package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SpecialNeeds {
    YES("Y"),
    NO("N"),
    UNDISCLOSED("U");

    public static final int LENGTH = 1;

    private String value;

    private SpecialNeeds(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, SpecialNeeds> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static SpecialNeeds fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<SpecialNeeds, String> {

        @Override
        public String convertToDatabaseColumn(SpecialNeeds attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public SpecialNeeds convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
