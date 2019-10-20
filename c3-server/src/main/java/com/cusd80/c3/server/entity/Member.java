package com.cusd80.c3.server.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.cusd80.c3.server.enums.ChildCareType;
import com.cusd80.c3.server.enums.EducationLevel;
import com.cusd80.c3.server.enums.EmploymentType;
import com.cusd80.c3.server.enums.Ethnicity;
import com.cusd80.c3.server.enums.Gender;
import com.cusd80.c3.server.enums.HousingType;
import com.cusd80.c3.server.enums.IncomeType;
import com.cusd80.c3.server.enums.InsuranceType;
import com.cusd80.c3.server.enums.Language;
import com.cusd80.c3.server.enums.MaritalStatus;
import com.cusd80.c3.server.enums.MemberType;
import com.cusd80.c3.server.enums.SelfIdentify;
import com.cusd80.c3.server.enums.SpecialNeeds;
import com.cusd80.c3.server.util.UUIDEntity;

import lombok.Data;

@Data
@Table(name = "member")
@Entity(name = "Member")
public class Member implements UUIDEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = STRATEGY)
    @Column(name = "member_id", nullable = false, length = 36)
    private String id;

    @Column(name = "parent_id", nullable = true, length = 36)
    private String parentId;

    @Column(name = "member_type", nullable = false, length = MemberType.LENGTH)
    private MemberType type;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @Column(name = "address_1", nullable = true, length = 50)
    private String address1;

    @Column(name = "address_2", nullable = true, length = 50)
    private String address2;

    @Column(name = "city", nullable = true, length = 50)
    private String city;

    @Column(name = "state", nullable = true, length = 2)
    private String state;

    @Column(name = "zip_code", nullable = true, length = 5)
    private String zipCode;

    @Column(name = "phone_number", nullable = true, length = 20)
    private String phoneNumber;

    @Column(name = "gender", nullable = true, length = Gender.LENGTH)
    private Gender gender;

    @Column(name = "marital_status", nullable = true, length = MaritalStatus.LENGTH)
    private MaritalStatus maritalStatus;

    @Column(name = "housing_type", nullable = true, length = HousingType.LENGTH)
    private HousingType housingType;

    @Column(name = "ethnicity", nullable = true, length = Ethnicity.LENGTH)
    private Ethnicity ethnicity;

    @Column(name = "self_identify", nullable = true, length = SelfIdentify.LENGTH)
    private SelfIdentify selfIdentify;

    @Column(name = "education_level", nullable = true, length = EducationLevel.LENGTH)
    private EducationLevel educationLevel;

    @Column(name = "language", nullable = true, length = Language.LENGTH)
    private Language language;

    @Column(name = "employment_type", nullable = true, length = EmploymentType.LENGTH)
    private EmploymentType employmentType;

    @ElementCollection
    @CollectionTable(name = "member_income_type", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "income_types", nullable = true, length = IncomeType.LENGTH)
    private Set<IncomeType> incomeTypes;

    @Column(name = "income_amount", nullable = true)
    private Integer incomeAmount;

    @Column(name = "insurance_type", nullable = true, length = InsuranceType.LENGTH)
    private InsuranceType insuranceType;

    @Column(name = "has_primary_care_provider", nullable = true)
    private Boolean hasPrimaryCareProvider;

    @Column(name = "has_dental_insurance", nullable = true)
    private Boolean hasDentalInsurance;

    @Column(name = "child_care_type", nullable = true, length = ChildCareType.LENGTH)
    private ChildCareType childCareType;

    @Column(name = "special_needs", nullable = true, length = SpecialNeeds.LENGTH)
    private SpecialNeeds specialNeeds;

    @Column(name = "school", nullable = true, length = 50)
    private String school;

    @Version
    @Column(name = "update_count", nullable = false)
    private long updateCount;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @PreUpdate
    @PrePersist
    private void onUpdate() {
        updateDate = LocalDateTime.now();
    }

}
