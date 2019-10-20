package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SelfIdentify {
    DISABILITY("D"),
    VETERAN("V"),
    MENTAL_ILLNESS("MI"),
    PREGNANT("PR"),
    POST_PARTUM("PP"),
    BREASTFEEDING("BF"),
    NOT_APPLICABLE("NA"),
    UNDISCLOSED("U"),
    OTHER("O"),
    ELDERLY("E"),
    LGBTQ("L"),
    FEMALE_HEAD_OF_HOUSEHOLD("FH");

    public static final int LENGTH = 2;

    private String value;

    private SelfIdentify(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, SelfIdentify> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static SelfIdentify fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<SelfIdentify, String> {

        @Override
        public String convertToDatabaseColumn(SelfIdentify attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public SelfIdentify convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
