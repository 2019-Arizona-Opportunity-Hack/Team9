package com.cusd80.c3.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CheckIn
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-10-19T21:10:37.422219-07:00[America/Phoenix]")

public class CheckIn   {
  @JsonProperty("member_id")
  private String memberId;

  @JsonProperty("service_id")
  private String serviceId;

  @JsonProperty("created_date")
  private String createdDate;

  public CheckIn memberId(String memberId) {
    this.memberId = memberId;
    return this;
  }

  /**
   * This is the caregiver or dependent id that corresponds to the person checking in for the given service. The field supports either ID since it is a UUID.
   * @return memberId
  */
  @ApiModelProperty(value = "This is the caregiver or dependent id that corresponds to the person checking in for the given service. The field supports either ID since it is a UUID.")


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public CheckIn serviceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

  /**
   * Get serviceId
   * @return serviceId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public CheckIn createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckIn checkIn = (CheckIn) o;
    return Objects.equals(this.memberId, checkIn.memberId) &&
        Objects.equals(this.serviceId, checkIn.serviceId) &&
        Objects.equals(this.createdDate, checkIn.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberId, serviceId, createdDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckIn {\n");
    
    sb.append("    memberId: ").append(toIndentedString(memberId)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
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

