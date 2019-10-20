package com.cusd80.c3.api.model;

import java.util.Objects;
import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Dependent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Family
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-19T21:10:37.422219-07:00[America/Phoenix]")

public class Family   {
  @JsonProperty("caregiver")
  private Caregiver caregiver = null;

  @JsonProperty("dependents")
  @Valid
  private List<Dependent> dependents = null;

  public Family caregiver(Caregiver caregiver) {
    this.caregiver = caregiver;
    return this;
  }

  /**
   * Get caregiver
   * @return caregiver
  */
  @ApiModelProperty(value = "")


  public Caregiver getCaregiver() {
    return caregiver;
  }

  public void setCaregiver(Caregiver caregiver) {
    this.caregiver = caregiver;
  }

  public Family dependents(List<Dependent> dependents) {
    this.dependents = dependents;
    return this;
  }

  public Family addDependentsItem(Dependent dependentsItem) {
    if (this.dependents == null) {
      this.dependents = new ArrayList<Dependent>();
    }
    this.dependents.add(dependentsItem);
    return this;
  }

  /**
   * Get dependents
   * @return dependents
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Dependent> getDependents() {
    return dependents;
  }

  public void setDependents(List<Dependent> dependents) {
    this.dependents = dependents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Family family = (Family) o;
    return Objects.equals(this.caregiver, family.caregiver) &&
        Objects.equals(this.dependents, family.dependents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caregiver, dependents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Family {\n");
    
    sb.append("    caregiver: ").append(toIndentedString(caregiver)).append("\n");
    sb.append("    dependents: ").append(toIndentedString(dependents)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

