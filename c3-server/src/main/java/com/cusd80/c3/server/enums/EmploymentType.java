package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmploymentType {
    POST_SECONDARY_STUDENT("PS"),
    FULL_TIME("FT"),
    PART_TIME("PT"),
    RETIRED("RT"),
    NONE("NE"),
    UNDISCLOSED("UD"),
    OTHER("OT");

    public static final int LENGTH = 2;

    private String value;

    private EmploymentType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, EmploymentType> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static EmploymentType fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<EmploymentType, String> {

        @Override
        public String convertToDatabaseColumn(EmploymentType attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public EmploymentType convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
