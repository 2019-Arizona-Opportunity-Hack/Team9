package com.cusd80.c3.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Income_Type
 */
public enum IncomeType {
  
  FT("FT"),
  
  CSFP("CSFP"),
  
  WIC("WIC"),
  
  SNAP("SNAP"),
  
  TANF("TANF"),
  
  DES_CHILDCARE_SUBSIDY("DES_Childcare_Subsidy"),
  
  QUALITY_FIRST_SCHOLAR("Quality_First_Scholar"),
  
  OTHER("Other");

  private String value;

  IncomeType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static IncomeType fromValue(String text) {
    for (IncomeType b : IncomeType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

