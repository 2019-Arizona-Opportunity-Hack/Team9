package com.cusd80.c3.api.model;

import java.util.Objects;
import com.cusd80.c3.api.model.Address;
import com.cusd80.c3.api.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Dependent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-19T21:10:37.422219-07:00[America/Phoenix]")

public class Dependent   {
  @JsonProperty("dependent_id")
  private String dependentId;

  @JsonProperty("person")
  private Person person = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("school")
  private String school;

  /**
   * Gets or Sets relationshipToCaregiver
   */
  public enum RelationshipToCaregiverEnum {
    SIBLING("Sibling"),
    
    SPOUSE("Spouse"),
    
    CHILD("Child"),
    
    PARENT("Parent"),
    
    GUARDIAN("Guardian"),
    
    GRANDPARENT("Grandparent"),
    
    FOSTER_PARENT("Foster_Parent");

    private String value;

    RelationshipToCaregiverEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RelationshipToCaregiverEnum fromValue(String text) {
      for (RelationshipToCaregiverEnum b : RelationshipToCaregiverEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("relationship_to_caregiver")
  private RelationshipToCaregiverEnum relationshipToCaregiver;

  public Dependent dependentId(String dependentId) {
    this.dependentId = dependentId;
    return this;
  }

  /**
   * Get dependentId
   * @return dependentId
  */
  @ApiModelProperty(value = "")


  public String getDependentId() {
    return dependentId;
  }

  public void setDependentId(String dependentId) {
    this.dependentId = dependentId;
  }

  public Dependent person(Person person) {
    this.person = person;
    return this;
  }

  /**
   * Get person
   * @return person
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Dependent address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Dependent school(String school) {
    this.school = school;
    return this;
  }

  /**
   * Get school
   * @return school
  */
  @ApiModelProperty(value = "")


  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public Dependent relationshipToCaregiver(RelationshipToCaregiverEnum relationshipToCaregiver) {
    this.relationshipToCaregiver = relationshipToCaregiver;
    return this;
  }

  /**
   * Get relationshipToCaregiver
   * @return relationshipToCaregiver
  */
  @ApiModelProperty(value = "")


  public RelationshipToCaregiverEnum getRelationshipToCaregiver() {
    return relationshipToCaregiver;
  }

  public void setRelationshipToCaregiver(RelationshipToCaregiverEnum relationshipToCaregiver) {
    this.relationshipToCaregiver = relationshipToCaregiver;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dependent dependent = (Dependent) o;
    return Objects.equals(this.dependentId, dependent.dependentId) &&
        Objects.equals(this.person, dependent.person) &&
        Objects.equals(this.address, dependent.address) &&
        Objects.equals(this.school, dependent.school) &&
        Objects.equals(this.relationshipToCaregiver, dependent.relationshipToCaregiver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dependentId, person, address, school, relationshipToCaregiver);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dependent {\n");
    
    sb.append("    dependentId: ").append(toIndentedString(dependentId)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    school: ").append(toIndentedString(school)).append("\n");
    sb.append("    relationshipToCaregiver: ").append(toIndentedString(relationshipToCaregiver)).append("\n");
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

