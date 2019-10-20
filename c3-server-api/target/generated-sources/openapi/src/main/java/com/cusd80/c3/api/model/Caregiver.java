package com.cusd80.c3.api.model;

import java.util.Objects;
import com.cusd80.c3.api.model.Address;
import com.cusd80.c3.api.model.Person;
import com.cusd80.c3.api.model.SelfIdentificationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Caregiver
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-19T21:10:37.422219-07:00[America/Phoenix]")

public class Caregiver   {
  @JsonProperty("caregiver_id")
  private String caregiverId;

  @JsonProperty("person")
  private Person person = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("income_amount")
  private SelfIdentificationType incomeAmount;

  /**
   * What type of housing is the member using?
   */
  public enum HousingTypeEnum {
    EMERGENCY_SHELTER_MISSION_TRANSITIONAL("Emergency_Shelter/Mission/Transitional"),
    
    EVACUEE("Evacuee"),
    
    OWN_HOME("Own_Home"),
    
    OTHER("Other");

    private String value;

    HousingTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static HousingTypeEnum fromValue(String text) {
      for (HousingTypeEnum b : HousingTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("housing_type")
  private HousingTypeEnum housingType;

  /**
   * What is the members level of education?
   */
  public enum EducationLevelEnum {
    GRADES_0_8("Grades_0-8"),
    
    GRADES_9_11("Grades_9-11"),
    
    HIGH_SCHOOL_DIPLOMA("High_School_Diploma"),
    
    GED("GED"),
    
    POST_SECONDARY("Post_Secondary"),
    
    TRADESCHOOL("Tradeschool"),
    
    _2_YEAR_DEGREE("2_Year_Degree"),
    
    _4_YEAR_DEGREE("4_Year_Degree"),
    
    MASTERS_DEGREE("Masters_Degree"),
    
    PHD("PhD"),
    
    UNDISCLOSED("Undisclosed");

    private String value;

    EducationLevelEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EducationLevelEnum fromValue(String text) {
      for (EducationLevelEnum b : EducationLevelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("education_level")
  private EducationLevelEnum educationLevel;

  /**
   * What is the members employment status?
   */
  public enum EmploymentTypeEnum {
    POST_SECONDARY_STUDENT("Post_Secondary_Student"),
    
    FULL_TIME("Full-Time"),
    
    PART_TIME("Part-Time"),
    
    RETIRED("Retired"),
    
    NONE("None"),
    
    DISCLOSED("Disclosed"),
    
    OTHER("Other");

    private String value;

    EmploymentTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EmploymentTypeEnum fromValue(String text) {
      for (EmploymentTypeEnum b : EmploymentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("employment_type")
  private EmploymentTypeEnum employmentType;

  /**
   * What type of medical insurance does the member have?
   */
  public enum InsuranceTypeEnum {
    EMPLOYER("Employer"),
    
    PRIVATE("Private"),
    
    AHCCCS("AHCCCS"),
    
    INDIAN_HEALTH_SERVICES("Indian_Health_Services"),
    
    MILITARY("Military"),
    
    NONE("None"),
    
    OTHER("Other");

    private String value;

    InsuranceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InsuranceTypeEnum fromValue(String text) {
      for (InsuranceTypeEnum b : InsuranceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("insurance_type")
  private InsuranceTypeEnum insuranceType;

  /**
   * What method of childcare does the family utilize?
   */
  public enum ChildCareTypeEnum {
    PARENT_PARTNER_CARE("Parent/Partner_Care"),
    
    HEAD_START("Head_Start"),
    
    CHILD_CARE_CENTER_PRESCHOOL_PROGRAM("Child_Care_Center/Preschool_Program"),
    
    FAMILY_CHILD_CARE_HOME("Family_Child_Care_Home"),
    
    RELATIVE_NEIGHBOR_OR_BABYSITTER("Relative/Neighbor_or_Babysitter");

    private String value;

    ChildCareTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ChildCareTypeEnum fromValue(String text) {
      for (ChildCareTypeEnum b : ChildCareTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("child_care_type")
  private ChildCareTypeEnum childCareType;

  /**
   * Marital status of the member.
   */
  public enum MaritalStatusEnum {
    SINGLE("Single"),
    
    MARRIED("Married"),
    
    DIVORCED("Divorced"),
    
    SEPARATED("Separated"),
    
    WIDOWED("Widowed"),
    
    UNDISCLOSED("Undisclosed");

    private String value;

    MaritalStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MaritalStatusEnum fromValue(String text) {
      for (MaritalStatusEnum b : MaritalStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("marital_status")
  private MaritalStatusEnum maritalStatus;

  public Caregiver caregiverId(String caregiverId) {
    this.caregiverId = caregiverId;
    return this;
  }

  /**
   * Get caregiverId
   * @return caregiverId
  */
  @ApiModelProperty(value = "")


  public String getCaregiverId() {
    return caregiverId;
  }

  public void setCaregiverId(String caregiverId) {
    this.caregiverId = caregiverId;
  }

  public Caregiver person(Person person) {
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

  public Caregiver address(Address address) {
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

  public Caregiver incomeAmount(SelfIdentificationType incomeAmount) {
    this.incomeAmount = incomeAmount;
    return this;
  }

  /**
   * Get incomeAmount
   * @return incomeAmount
  */
  @ApiModelProperty(value = "")

  @Valid

  public SelfIdentificationType getIncomeAmount() {
    return incomeAmount;
  }

  public void setIncomeAmount(SelfIdentificationType incomeAmount) {
    this.incomeAmount = incomeAmount;
  }

  public Caregiver housingType(HousingTypeEnum housingType) {
    this.housingType = housingType;
    return this;
  }

  /**
   * What type of housing is the member using?
   * @return housingType
  */
  @ApiModelProperty(value = "What type of housing is the member using?")


  public HousingTypeEnum getHousingType() {
    return housingType;
  }

  public void setHousingType(HousingTypeEnum housingType) {
    this.housingType = housingType;
  }

  public Caregiver educationLevel(EducationLevelEnum educationLevel) {
    this.educationLevel = educationLevel;
    return this;
  }

  /**
   * What is the members level of education?
   * @return educationLevel
  */
  @ApiModelProperty(value = "What is the members level of education?")


  public EducationLevelEnum getEducationLevel() {
    return educationLevel;
  }

  public void setEducationLevel(EducationLevelEnum educationLevel) {
    this.educationLevel = educationLevel;
  }

  public Caregiver employmentType(EmploymentTypeEnum employmentType) {
    this.employmentType = employmentType;
    return this;
  }

  /**
   * What is the members employment status?
   * @return employmentType
  */
  @ApiModelProperty(value = "What is the members employment status?")


  public EmploymentTypeEnum getEmploymentType() {
    return employmentType;
  }

  public void setEmploymentType(EmploymentTypeEnum employmentType) {
    this.employmentType = employmentType;
  }

  public Caregiver insuranceType(InsuranceTypeEnum insuranceType) {
    this.insuranceType = insuranceType;
    return this;
  }

  /**
   * What type of medical insurance does the member have?
   * @return insuranceType
  */
  @ApiModelProperty(value = "What type of medical insurance does the member have?")


  public InsuranceTypeEnum getInsuranceType() {
    return insuranceType;
  }

  public void setInsuranceType(InsuranceTypeEnum insuranceType) {
    this.insuranceType = insuranceType;
  }

  public Caregiver childCareType(ChildCareTypeEnum childCareType) {
    this.childCareType = childCareType;
    return this;
  }

  /**
   * What method of childcare does the family utilize?
   * @return childCareType
  */
  @ApiModelProperty(value = "What method of childcare does the family utilize?")


  public ChildCareTypeEnum getChildCareType() {
    return childCareType;
  }

  public void setChildCareType(ChildCareTypeEnum childCareType) {
    this.childCareType = childCareType;
  }

  public Caregiver maritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Marital status of the member.
   * @return maritalStatus
  */
  @ApiModelProperty(value = "Marital status of the member.")


  public MaritalStatusEnum getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatusEnum maritalStatus) {
    this.maritalStatus = maritalStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Caregiver caregiver = (Caregiver) o;
    return Objects.equals(this.caregiverId, caregiver.caregiverId) &&
        Objects.equals(this.person, caregiver.person) &&
        Objects.equals(this.address, caregiver.address) &&
        Objects.equals(this.incomeAmount, caregiver.incomeAmount) &&
        Objects.equals(this.housingType, caregiver.housingType) &&
        Objects.equals(this.educationLevel, caregiver.educationLevel) &&
        Objects.equals(this.employmentType, caregiver.employmentType) &&
        Objects.equals(this.insuranceType, caregiver.insuranceType) &&
        Objects.equals(this.childCareType, caregiver.childCareType) &&
        Objects.equals(this.maritalStatus, caregiver.maritalStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caregiverId, person, address, incomeAmount, housingType, educationLevel, employmentType, insuranceType, childCareType, maritalStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Caregiver {\n");
    
    sb.append("    caregiverId: ").append(toIndentedString(caregiverId)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    incomeAmount: ").append(toIndentedString(incomeAmount)).append("\n");
    sb.append("    housingType: ").append(toIndentedString(housingType)).append("\n");
    sb.append("    educationLevel: ").append(toIndentedString(educationLevel)).append("\n");
    sb.append("    employmentType: ").append(toIndentedString(employmentType)).append("\n");
    sb.append("    insuranceType: ").append(toIndentedString(insuranceType)).append("\n");
    sb.append("    childCareType: ").append(toIndentedString(childCareType)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
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

