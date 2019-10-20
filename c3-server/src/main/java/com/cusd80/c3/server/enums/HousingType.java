package com.cusd80.c3.server.enums;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum HousingType {
    EMERGENCY("EM"),
    EVACUEE("EV"),
    OWN_HOME("OH"),
    OTHER("O"),
    PRIVATE_RENTAL("PR"),
    PUBLIC_HOUSING("PH"),
    UNDISCLOSED("U"),
    UNHOUSED("UH"),
    WITH_FAMILY_FRIENDS("WF"),
    YOUTH_HOME_SHELTER("YH"),
    REFUGEE("R");

    public static final int LENGTH = 2;

    private String value;

    private HousingType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    private static final Map<String, HousingType> FROM_STRING = new LinkedHashMap<>();
    static {
        for (var value : values()) {
            FROM_STRING.put(value.name(), value);
            FROM_STRING.put(value.toString(), value);
        }
    }

    @JsonCreator
    public static HousingType fromString(String value) {
        if (value == null) return null;
        return FROM_STRING.get(value.toUpperCase());
    }

    @Converter(autoApply = true)
    public static class Convert implements AttributeConverter<HousingType, String> {

        @Override
        public String convertToDatabaseColumn(HousingType attribute) {
            if (attribute == null) return null;
            return attribute.toString();
        }

        @Override
        public HousingType convertToEntityAttribute(String dbData) {
            return fromString(dbData);
        }

    }

}
