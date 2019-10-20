package com.cusd80.c3.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * What is the members primary language?
 */
public enum PrimaryLanguage {
  
  ENGLISH("English"),
  
  SPANISH("Spanish"),
  
  OTHER("Other");

  private String value;

  PrimaryLanguage(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PrimaryLanguage fromValue(String text) {
    for (PrimaryLanguage b : PrimaryLanguage.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }
}

