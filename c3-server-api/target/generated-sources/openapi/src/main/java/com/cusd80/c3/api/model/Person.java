package com.cusd80.c3.api.model;

import java.util.Objects;
import com.cusd80.c3.api.model.SelfIdentificationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Person
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-19T21:10:37.422219-07:00[America/Phoenix]")

public class Person   {
  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("date_of_birth")
  private String dateOfBirth;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    MALE("Male"),
    
    FEMALE("Female");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender;

  @JsonProperty("medical_insurer")
  private String medicalInsurer;

  @JsonProperty("has_primary_care_provider")
  private Boolean hasPrimaryCareProvider;

  @JsonProperty("has_dental_insurance")
  private Boolean hasDentalInsurance;

  @JsonProperty("has_special_needs")
  private Boolean hasSpecialNeeds;

  @JsonProperty("self_identifies_as")
  private SelfIdentificationType selfIdentifiesAs;

  @JsonProperty("primary_language")
  private String primaryLanguage;

  /**
   * Which ethnicity does the member relate to?
   */
  public enum EthnicityTypeEnum {
    WHITE_ANGLO("White/Anglo"),
    
    BLACK_AFRICAN_AMERICAN("Black/African_American"),
    
    HISPANIC_LATINO("Hispanic/Latino"),
    
    AMERICAN_INDIAN_NATIVE_AMERICAN("American_Indian/Native_American"),
    
    ASIAN("Asian"),
    
    ALASKA_NATIVE_ALEUT_ESKIMO("Alaska_Native/Aleut/Eskimo"),
    
    MIDDLE_EASTERN_NORTH_AFRICAN("Middle-Eastern/North-African"),
    
    OTHER("Other"),
    
    UNDISCLOSED("Undisclosed");

    private String value;

    EthnicityTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EthnicityTypeEnum fromValue(String text) {
      for (EthnicityTypeEnum b : EthnicityTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("ethnicity_type")
  private EthnicityTypeEnum ethnicityType;

  public Person firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Person lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Person dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Person gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @ApiModelProperty(value = "")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public Person medicalInsurer(String medicalInsurer) {
    this.medicalInsurer = medicalInsurer;
    return this;
  }

  /**
   * Get medicalInsurer
   * @return medicalInsurer
  */
  @ApiModelProperty(value = "")


  public String getMedicalInsurer() {
    return medicalInsurer;
  }

  public void setMedicalInsurer(String medicalInsurer) {
    this.medicalInsurer = medicalInsurer;
  }

  public Person hasPrimaryCareProvider(Boolean hasPrimaryCareProvider) {
    this.hasPrimaryCareProvider = hasPrimaryCareProvider;
    return this;
  }

  /**
   * Get hasPrimaryCareProvider
   * @return hasPrimaryCareProvider
  */
  @ApiModelProperty(value = "")


  public Boolean getHasPrimaryCareProvider() {
    return hasPrimaryCareProvider;
  }

  public void setHasPrimaryCareProvider(Boolean hasPrimaryCareProvider) {
    this.hasPrimaryCareProvider = hasPrimaryCareProvider;
  }

  public Person hasDentalInsurance(Boolean hasDentalInsurance) {
    this.hasDentalInsurance = hasDentalInsurance;
    return this;
  }

  /**
   * Get hasDentalInsurance
   * @return hasDentalInsurance
  */
  @ApiModelProperty(value = "")


  public Boolean getHasDentalInsurance() {
    return hasDentalInsurance;
  }

  public void setHasDentalInsurance(Boolean hasDentalInsurance) {
    this.hasDentalInsurance = hasDentalInsurance;
  }

  public Person hasSpecialNeeds(Boolean hasSpecialNeeds) {
    this.hasSpecialNeeds = hasSpecialNeeds;
    return this;
  }

  /**
   * Get hasSpecialNeeds
   * @return hasSpecialNeeds
  */
  @ApiModelProperty(value = "")


  public Boolean getHasSpecialNeeds() {
    return hasSpecialNeeds;
  }

  public void setHasSpecialNeeds(Boolean hasSpecialNeeds) {
    this.hasSpecialNeeds = hasSpecialNeeds;
  }

  public Person selfIdentifiesAs(SelfIdentificationType selfIdentifiesAs) {
    this.selfIdentifiesAs = selfIdentifiesAs;
    return this;
  }

  /**
   * Get selfIdentifiesAs
   * @return selfIdentifiesAs
  */
  @ApiModelProperty(value = "")

  @Valid

  public SelfIdentificationType getSelfIdentifiesAs() {
    return selfIdentifiesAs;
  }

  public void setSelfIdentifiesAs(SelfIdentificationType selfIdentifiesAs) {
    this.selfIdentifiesAs = selfIdentifiesAs;
  }

  public Person primaryLanguage(String primaryLanguage) {
    this.primaryLanguage = primaryLanguage;
    return this;
  }

  /**
   * Get primaryLanguage
   * @return primaryLanguage
  */
  @ApiModelProperty(value = "")


  public String getPrimaryLanguage() {
    return primaryLanguage;
  }

  public void setPrimaryLanguage(String primaryLanguage) {
    this.primaryLanguage = primaryLanguage;
  }

  public Person ethnicityType(EthnicityTypeEnum ethnicityType) {
    this.ethnicityType = ethnicityType;
    return this;
  }

  /**
   * Which ethnicity does the member relate to?
   * @return ethnicityType
  */
  @ApiModelProperty(value = "Which ethnicity does the member relate to?")


  public EthnicityTypeEnum getEthnicityType() {
    return ethnicityType;
  }

  public void setEthnicityType(EthnicityTypeEnum ethnicityType) {
    this.ethnicityType = ethnicityType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.firstName, person.firstName) &&
        Objects.equals(this.lastName, person.lastName) &&
        Objects.equals(this.dateOfBirth, person.dateOfBirth) &&
        Objects.equals(this.gender, person.gender) &&
        Objects.equals(this.medicalInsurer, person.medicalInsurer) &&
        Objects.equals(this.hasPrimaryCareProvider, person.hasPrimaryCareProvider) &&
        Objects.equals(this.hasDentalInsurance, person.hasDentalInsurance) &&
        Objects.equals(this.hasSpecialNeeds, person.hasSpecialNeeds) &&
        Objects.equals(this.selfIdentifiesAs, person.selfIdentifiesAs) &&
        Objects.equals(this.primaryLanguage, person.primaryLanguage) &&
        Objects.equals(this.ethnicityType, person.ethnicityType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, dateOfBirth, gender, medicalInsurer, hasPrimaryCareProvider, hasDentalInsurance, hasSpecialNeeds, selfIdentifiesAs, primaryLanguage, ethnicityType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    medicalInsurer: ").append(toIndentedString(medicalInsurer)).append("\n");
    sb.append("    hasPrimaryCareProvider: ").append(toIndentedString(hasPrimaryCareProvider)).append("\n");
    sb.append("    hasDentalInsurance: ").append(toIndentedString(hasDentalInsurance)).append("\n");
    sb.append("    hasSpecialNeeds: ").append(toIndentedString(hasSpecialNeeds)).append("\n");
    sb.append("    selfIdentifiesAs: ").append(toIndentedString(selfIdentifiesAs)).append("\n");
    sb.append("    primaryLanguage: ").append(toIndentedString(primaryLanguage)).append("\n");
    sb.append("    ethnicityType: ").append(toIndentedString(ethnicityType)).append("\n");
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

