package com.cusd80.c3.server.util;

import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Dependent;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.api.model.IncomeType;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.enums.MemberType;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.internal.inject.ParamConverters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FamilyMapper {

    public static MemberEntity toParentEntity(Family family)
    {

        //this code is horrid but it works so...

        MemberEntity member = new MemberEntity();

        if (family.getCaregiver().getAddress() != null)
        {
            member.setAddress1(family.getCaregiver().getAddress().getAddressLine1());
            member.setAddress2(family.getCaregiver().getAddress().getAddressLine2());
            member.setCity(family.getCaregiver().getAddress().getCity());
            member.setState(family.getCaregiver().getAddress().getState());
            member.setZipCode(family.getCaregiver().getAddress().getZip());
        }

        member.setChildCareType(family.getCaregiver().getChildCareType() == null ? "" : family.getCaregiver().getChildCareType().toString());

        if (family.getCaregiver().getEducationLevel() != null) {
            member.setEducationLevel(family.getCaregiver().getEducationLevel().toString());
        }

        if (family.getCaregiver().getEmploymentType() != null) {
            member.setEmploymentType(family.getCaregiver().getEmploymentType().toString());
        }

        if (family.getCaregiver().getPerson().getEthnicityType() != null) {
            member.setEthnicity(family.getCaregiver().getPerson().getEthnicityType().toString());
        }

        member.setFirstName(family.getCaregiver().getPerson().getFirstName());
        member.setLastName(family.getCaregiver().getPerson().getLastName());

        if (family.getCaregiver().getPerson().getGender() != null) {
            member.setGender(family.getCaregiver().getPerson().getGender().toString());
        }

        member.setHasDentalInsurance(family.getCaregiver().getPerson().getHasDentalInsurance());
        member.setHasPrimaryCareProvider(family.getCaregiver().getPerson().getHasPrimaryCareProvider());

        if (family.getCaregiver().getHousingType() != null)
        {
            member.setHousingType(family.getCaregiver().getHousingType().toString());
        }

        member.setIncomeAmount(family.getCaregiver().getIncomeAmount());

        if (family.getCaregiver().getInsuranceType() != null)
        {
            member.setInsuranceType(family.getCaregiver().getInsuranceType().toString());
        }

        if (family.getCaregiver().getEmploymentType().toString() != null)
        {
            member.setEmploymentType(family.getCaregiver().getEmploymentType().toString());
        }

        if (family.getCaregiver().getMaritalStatus() != null)
        {
            member.setMaritalStatus(family.getCaregiver().getMaritalStatus().toString());
        }

        if (family.getCaregiver().getPerson().getSelfIdentifiesAs() != null)
        {
            member.setSelfIdentify(family.getCaregiver().getPerson().getSelfIdentifiesAs().toString());
        }

        member.setPhoneNumber(family.getCaregiver().getAddress().getPhone());

        member.setType(MemberType.PRIMARY);
        member.setUpdateDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        //inefficient but works...having some trouble getting the conversion right so went with a loop
        HashSet<String> set = new HashSet<String>();
        for (IncomeType incomeType: family.getCaregiver().getIncomeTypes()) {
            set.add(incomeType.toString());
        }

        member.setIncomeTypes(set);

        //this is crap code but i dont care.
        if (family.getCaregiver().getPerson().getDateOfBirth() == null) {
            throw new IllegalArgumentException("DOB was null. This value must be provided.");
        }
        else {
            DateTimeFormatter dTF = DateTimeFormatter.ofPattern("yyyyMMdd");
            member.setBirthDate(LocalDate.parse(family.getCaregiver().getPerson().getDateOfBirth(), dTF));
        }

        return member;
    }


    public static List<MemberEntity> toDependentEntities(Family family)
    {
        MemberEntity member = new MemberEntity();
        List<Dependent> dependents = family.getDependents();
        List<MemberEntity> members = new ArrayList<MemberEntity>();

        for (Dependent dependent : dependents)
        {
            member = new MemberEntity();
            member.setType(MemberType.DEPENDENT);
            member.setParentId(family.getCaregiver().getCaregiverId());

            if (family.getCaregiver().getAddress() != null) {
                member.setAddress1(dependent.getAddress().getAddressLine1());
                member.setAddress2(dependent.getAddress().getAddressLine2());
                member.setCity(dependent.getAddress().getCity());
                member.setState(dependent.getAddress().getState());
                member.setZipCode(dependent.getAddress().getZip());
            }

            member.setFirstName(dependent.getPerson().getFirstName());
            member.setLastName(dependent.getPerson().getLastName());
            member.setHasDentalInsurance(dependent.getPerson().getHasDentalInsurance());
            member.setHasPrimaryCareProvider(dependent.getPerson().getHasPrimaryCareProvider());
            member.setPhoneNumber(dependent.getAddress().getPhone());
            member.setSchool(dependent.getSchool());

            if (dependent.getPerson().getEthnicityType() != null)
            {
                member.setEthnicity(dependent.getPerson().getEthnicityType().toString());
            }

            if (dependent.getPerson().getSelfIdentifiesAs() != null)
            {
                member.setSelfIdentify(dependent.getPerson().getSelfIdentifiesAs().toString());
            }

            if (dependent.getPerson().getGender() != null)
            {
                member.setGender(dependent.getPerson().getGender().toString());
            }

            if (dependent.getPerson().getHasSpecialNeeds() != null)
            {
                member.setSpecialNeeds(dependent.getPerson().getHasSpecialNeeds().toString());
            }

            member.setUpdateDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
            members.add(member);
        }
        return members;
    }

}
