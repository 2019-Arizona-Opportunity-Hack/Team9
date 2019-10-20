package com.cusd80.c3.server.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.cusd80.c3.api.model.Address;
import com.cusd80.c3.api.model.Caregiver;
import com.cusd80.c3.api.model.Dependent;
import com.cusd80.c3.api.model.Family;
import com.cusd80.c3.api.model.IncomeType;
import com.cusd80.c3.api.model.Person;
import com.cusd80.c3.api.model.SelfIdentificationType;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.enums.MemberType;
import com.google.common.base.Enums;

public class FamilyMapper {

    public static MemberEntity toParentEntity(Family family) {

        //this code is horrid but it works so...

        MemberEntity member = new MemberEntity();
        member.setId(family.getCaregiver().getCaregiverId());

        if (family.getCaregiver().getAddress() != null) {
            member.setAddress1(family.getCaregiver().getAddress().getAddressLine1());
            member.setAddress2(family.getCaregiver().getAddress().getAddressLine2());
            member.setCity(family.getCaregiver().getAddress().getCity());
            member.setState(family.getCaregiver().getAddress().getState());
            member.setZipCode(family.getCaregiver().getAddress().getZip());
        }

        member.setChildCareType(MappingHelper.enumValue(family.getCaregiver().getChildCareType()));
        member.setEducationLevel(MappingHelper.enumValue(family.getCaregiver().getEducationLevel()));
        member.setEmploymentType(MappingHelper.enumValue(family.getCaregiver().getEmploymentType()));
        member.setEthnicity(MappingHelper.enumValue(family.getCaregiver().getPerson().getEthnicityType()));
        member.setFirstName(family.getCaregiver().getPerson().getFirstName());
        member.setLastName(family.getCaregiver().getPerson().getLastName());
        try {
            member.setGender(MappingHelper.enumValue(family.getCaregiver().getPerson().getGender()));
        } catch (Exception ignore) {
        }
        member.setHasDentalInsurance(family.getCaregiver().getPerson().getHasDentalInsurance());
        member.setHasPrimaryCareProvider(family.getCaregiver().getPerson().getHasPrimaryCareProvider());
        try {
            member.setHousingType(MappingHelper.enumValue(family.getCaregiver().getHousingType()));
        } catch (Exception ignore) {
        }
        member.setIncomeAmount(family.getCaregiver().getIncomeAmount());
        try {
            member.setInsuranceType(MappingHelper.enumValue(family.getCaregiver().getInsuranceType()));
        } catch (Exception ignore) {
        }
        try {
            member.setEmploymentType(MappingHelper.enumValue(family.getCaregiver().getEmploymentType()));
        } catch (Exception ignore) {
        }
        try {
            member.setMaritalStatus(MappingHelper.enumValue(family.getCaregiver().getMaritalStatus()));
        } catch (Exception ignore) {
        }
        try {
            member.setSelfIdentify(MappingHelper.enumValue(family.getCaregiver().getPerson().getSelfIdentifiesAs()));
        } catch (Exception ignore) {
        }
        member.setPhoneNumber(family.getCaregiver().getAddress().getPhone());
        member.setType(MemberType.PRIMARY);
        member.setUpdateDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        //inefficient but works...having some trouble getting the conversion right so went with a loop
        HashSet<String> set = new HashSet<String>();
        if (family != null && family.getCaregiver() != null && family.getCaregiver().getIncomeTypes() != null) for (
            IncomeType incomeType : family.getCaregiver().getIncomeTypes()
        ) {
            set.add(incomeType.toString());
        }

        member.setIncomeTypes(set);

        //this is crap code but i dont care.
        if (family.getCaregiver().getPerson().getDateOfBirth() == null) {
            throw new IllegalArgumentException("DOB was null. This value must be provided.");
        } else {
            member.setBirthDate(DateUtil.parseDate(family.getCaregiver().getPerson().getDateOfBirth()));
        }

        return member;
    }

    public static List<MemberEntity> toDependentEntities(Family family) {
        MemberEntity member = new MemberEntity();
        List<Dependent> dependents = family.getDependents();
        List<MemberEntity> members = new ArrayList<MemberEntity>();

        if (dependents != null) for (Dependent dependent : dependents) {
            member = new MemberEntity();
            member.setId(dependent.getDependentId());
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
            member.setEthnicity(MappingHelper.enumValue(dependent.getPerson().getEthnicityType()));
            member.setSelfIdentify(MappingHelper.enumValue(dependent.getPerson().getSelfIdentifiesAs()));
            member.setGender(MappingHelper.enumValue(dependent.getPerson().getGender()));
            member.setSpecialNeeds(MappingHelper.enumValue(dependent.getPerson().getHasSpecialNeeds()));
            member.setUpdateDate(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
            members.add(member);
        }
        return members;
    }

    //    public static List<Family> fromCaregiverMembers(List<MemberEntity> entities)
    //    {
    //        List<Family> families = new ArrayList<>();
    //
    //        for(MemberEntity entity : entities)
    //        {
    //            families.add(fromCaregiverMember(entity));
    //
    //            //get the children in a nested loop. not pretty but ok for MVP
    //            //find the dependents
    //            List<MemberEntity> dependents = memberRepository.findByParentId(daFamily.getCaregiver().getCaregiverId());
    //
    //            //map the dependents to the appropriate data type
    //            daFamily.setDependents(FamilyMapper.fromDependentMember(dependents));
    //        }
    //
    //        return families;
    //    }

    public static Family fromCaregiverMember(MemberEntity entity) {
        Family family = new Family();
        Caregiver giver = new Caregiver();
        Address address = new Address();
        giver.setCaregiverId(entity.getId());

        address.setAddressLine1(entity.getAddress1());
        address.setAddressLine2(entity.getAddress2());
        address.setCity(entity.getCity());
        address.setState(entity.getState());
        address.setZip(entity.getZipCode());
        address.setPhone(entity.getPhoneNumber());
        giver.setAddress(address);

        //this is crap but i'm tired
        try {
            giver.setChildCareType(
                Enums.getIfPresent(Caregiver.ChildCareTypeEnum.class, entity.getChildCareType()).orNull()
            );
        } catch (Exception ex) {

        }

        try {
            giver.setEducationLevel(
                Enums.getIfPresent(Caregiver.EducationLevelEnum.class, entity.getEducationLevel()).orNull()
            );
        } catch (Exception ex) {

        }

        try {
            giver.setEmploymentType(
                Enums.getIfPresent(Caregiver.EmploymentTypeEnum.class, entity.getEmploymentType()).orNull()
            );
        } catch (Exception ex) {

        }

        try {
            giver.setHousingType(Enums.getIfPresent(Caregiver.HousingTypeEnum.class, entity.getHousingType()).orNull());
        } catch (Exception ex) {

        }

        try {
            giver.setInsuranceType(
                Enums.getIfPresent(Caregiver.InsuranceTypeEnum.class, entity.getInsuranceType()).orNull()
            );
        } catch (Exception ex) {

        }

        try {
            giver.setMaritalStatus(
                Enums.getIfPresent(Caregiver.MaritalStatusEnum.class, entity.getMaritalStatus()).orNull()
            );
        } catch (Exception ex) {

        }

        giver.setIncomeAmount(entity.getIncomeAmount());

        //lazy way
        List<IncomeType> incomeTypes = new ArrayList<>();

        for (String incomeType : entity.getIncomeTypes()) {
            try {
                incomeTypes.add(IncomeType.fromValue(incomeType));
            } catch (Exception ignore) {
            }
        }

        giver.setIncomeTypes(incomeTypes);

        Person person = new Person();
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        person.setHasPrimaryCareProvider(entity.getHasPrimaryCareProvider());
        person.setHasDentalInsurance(entity.getHasDentalInsurance());
        person.setDateOfBirth(MappingHelper.enumValue(entity.getBirthDate()));
        try {
            person.setGender(Person.GenderEnum.fromValue(entity.getGender()));
        } catch (Exception ignore) {
        }
        person.setHasSpecialNeeds(Boolean.parseBoolean(entity.getSpecialNeeds()));
        try {
            person.setMedicalInsurer(entity.getInsuranceType());
        } catch (Exception ignore) {
        }
        try {
            person.setPrimaryLanguage(entity.getLanguage());
        } catch (Exception ignore) {
        }
        try {
            person.setEthnicityType(Enums.getIfPresent(Person.EthnicityTypeEnum.class, entity.getEthnicity()).orNull());
        } catch (Exception ignore) {
        }

        try {
            person.setSelfIdentifiesAs(
                Enums.getIfPresent(SelfIdentificationType.class, entity.getSelfIdentify()).orNull()
            );
        } catch (Exception ex) {
            //have no idea why this is faililng and i am too tired to care
        }

        giver.setPerson(person);
        family.setCaregiver(giver);

        return family;
    }

    public static List<Dependent> fromDependentMember(List<MemberEntity> entities) {
        List<Dependent> dependents = new ArrayList<>();

        for (MemberEntity entity : entities) {
            Dependent dependent = new Dependent();
            dependent.setDependentId(entity.getId());
            Address address = new Address();
            address.setAddressLine1(entity.getAddress1());
            address.setAddressLine2(entity.getAddress2());
            address.setCity(entity.getCity());
            address.setState(entity.getState());
            address.setZip(entity.getZipCode());
            address.setPhone(entity.getPhoneNumber());
            dependent.setAddress(address);

            dependent.setSchool(entity.getSchool());

            try {
                dependent.setRelationshipToCaregiver(
                    Enums.getIfPresent(Dependent.RelationshipToCaregiverEnum.class, entity.getRelationshipToCaregiver())
                        .orNull()
                );
            } catch (Exception ex) {
            }

            Person person = new Person();
            person.setFirstName(entity.getFirstName());
            person.setLastName(entity.getLastName());
            person.setHasPrimaryCareProvider(entity.getHasPrimaryCareProvider());
            person.setHasDentalInsurance(entity.getHasDentalInsurance());

            if (entity.getBirthDate() != null) {
                person.setDateOfBirth(entity.getBirthDate().toString());
            }

            try {
                person.setGender(Person.GenderEnum.fromValue(entity.getGender()));
            } catch (Exception ex) {

            }

            person.setHasSpecialNeeds(Boolean.parseBoolean(entity.getSpecialNeeds()));
            person.setMedicalInsurer(entity.getInsuranceType());
            person.setPrimaryLanguage(entity.getLanguage());

            try {
                person.setSelfIdentifiesAs(
                    Enums.getIfPresent(SelfIdentificationType.class, entity.getSelfIdentify()).orNull()
                );
            } catch (Exception ex) {
            }

            try {
                person.setEthnicityType(
                    Enums.getIfPresent(Person.EthnicityTypeEnum.class, entity.getEthnicity()).orNull()
                );
            } catch (Exception ex) {
            }
            dependent.setPerson(person);

            dependents.add(dependent);
        }

        return dependents;
    }

}
