package com.cusd80.c3.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Self_Identification_Type
 */
public enum SelfIdentificationType {
  
  DISABILITY("Disability"),
  
  VETEREN("Veteren"),
  
  MENTAL_ILLNESS("Mental_Illness"),
  
  PREGNANT("Pregnant"),
  
  POSTPARTUM("Postpartum"),
  
  BREASTFEEDING("Breastfeeding"),
  
  N_A("N/A"),
  
  UNDISCLOSED("Undisclosed"),
  
  OTHER("Other"),
  
  ELDERLY__62_("Elderly_(62+)"),
  
  LGBTQ("LGBTQ"),
  
  FEMALE_HEAD_OF_HOUSEHOLD("Female_Head_of_Household");

  private String value;

  SelfIdentificationType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SelfIdentificationType fromValue(String text) {
    for (SelfIdentificationType b : SelfIdentificationType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

