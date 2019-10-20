package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MemberType {
    PRIMARY("P"),
    DEPENDENT("D");

    public static final int LENGTH = 1;

    private String value;

    private MemberType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, MemberType> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static MemberType fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<MemberType, String> {

        @Override
        public String convertToDatabaseColumn(MemberType attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public MemberType convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
