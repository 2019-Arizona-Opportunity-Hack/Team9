package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EducationLevel {
    GRADES_0_8("G08"),
    GRADES_9_11("G11"),
    HIGH_SCHOOL("HSD"),
    GED("GED"),
    POST_SECONDARY("PSE"),
    TRADESCHOOL("TRD"),
    DEGREE_2YR("2YR"),
    DEGREE_4YR("4YR"),
    MASTERS("MAS"),
    PHD("PHD"),
    UNDISCLOSED("UND");

    public static final int LENGTH = 3;

    private String value;

    private EducationLevel(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, EducationLevel> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static EducationLevel fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<EducationLevel, String> {

        @Override
        public String convertToDatabaseColumn(EducationLevel attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public EducationLevel convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
