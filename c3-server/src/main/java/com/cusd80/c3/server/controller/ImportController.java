package com.cusd80.c3.server.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashSet;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cusd80.c3.api.ImportApi;
import com.cusd80.c3.server.entity.CheckInEntity;
import com.cusd80.c3.server.entity.MemberEntity;
import com.cusd80.c3.server.entity.ServiceEntity;
import com.cusd80.c3.server.enums.MemberType;
import com.cusd80.c3.server.repo.CheckInRepository;
import com.cusd80.c3.server.repo.MemberRepository;
import com.cusd80.c3.server.repo.ServiceRepository;
import com.cusd80.c3.server.util.DateUtil;
import com.cusd80.c3.server.vo.ImportResult;

@RestController
@Transactional
@RequestMapping("import")
public class ImportController implements ImportApi {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CheckInRepository checkInRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> importRedirect() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "import.html").build();
    }

    @RequestMapping(
        path = "services",
        method = RequestMethod.POST,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImportResult importServices(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new IOException("Empty File");
        memberRepository.deleteAll();
        try (
            var csv = new CSVParser(
                new InputStreamReader(file.getInputStream(), StandardCharsets.ISO_8859_1),
                CSVFormat.EXCEL.withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withIgnoreEmptyLines()
                    .withAllowMissingColumnNames()
            )
        ) {
            ImportResult result = new ImportResult();
            csv.forEach(rec -> {
                ServiceEntity service = serviceRepository.findById(rec.get("id")).orElseGet(ServiceEntity::new);
                service.setId(rec.get("id"));
                service.setName(rec.get("name"));
                service.setSortOrder(NumberUtils.toInt(rec.get("order")));
                service.setEnabled(BooleanUtils.toBoolean(rec.get("enabled")));
                serviceRepository.save(service);
                result.addRecordsImported(1);
            });
            return result;
        }
    }

    @RequestMapping(
        path = "members",
        method = RequestMethod.POST,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImportResult importMembers(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new IOException("Empty File");
        try (
            var csv = new CSVParser(
                new InputStreamReader(file.getInputStream(), StandardCharsets.ISO_8859_1),
                CSVFormat.EXCEL.withFirstRecordAsHeader()
                    .withAllowMissingColumnNames()
                    .withIgnoreHeaderCase()
                    .withIgnoreEmptyLines()
            )
        ) {
            ImportResult result = new ImportResult();
            csv.forEach(rec -> {
                MemberEntity member = new MemberEntity();
                member.setId(rec.get("id"));
                member.setParentId(rec.get("parentId"));
                member.setType(MemberType.fromString(rec.get("type")));
                member.setFirstName(rec.get("firstName"));
                member.setLastName(rec.get("lastName"));
                member.setBirthDate(DateUtil.parseDate(rec.get("birthDate")));
                member.setAddress1(rec.get("address1"));
                member.setAddress2(rec.get("address2"));
                member.setCity(rec.get("city"));
                member.setState(rec.get("state"));
                member.setZipCode(rec.get("zipCode"));
                member.setPhoneNumber(rec.get("phoneNumber"));
                member.setGender(rec.get("gender"));
                member.setMaritalStatus(rec.get("maritalStatus"));
                member.setHousingType(rec.get("housingType"));
                member.setEthnicity(rec.get("ethnicity"));
                member.setSelfIdentify(rec.get("selfIdentify"));
                member.setEducationLevel(rec.get("educationLevel"));
                member.setLanguage(rec.get("language"));
                member.setEmploymentType(rec.get("employmentType"));
                member.setIncomeTypes(
                    new LinkedHashSet<>(
                        Arrays.asList(StringUtils.defaultIfBlank(rec.get("incomeTypes"), "").split("\\|"))
                    )
                );
                member.setIncomeAmount(NumberUtils.toInt(rec.get("incomeAmount")));
                member.setInsuranceType(rec.get("insuranceType"));
                member.setHasPrimaryCareProvider(BooleanUtils.toBooleanObject(rec.get("hasPrimaryCareProvider")));
                member.setHasDentalInsurance(BooleanUtils.toBooleanObject(rec.get("hasDentalInsurance")));
                member.setChildCareType(rec.get("childCareType"));
                member.setSpecialNeeds(rec.get("specialNeeds"));
                member.setSchool(rec.get("school"));
                member.setUpdateDate(DateUtil.parseDateTime(rec.get("updateDate")));

                memberRepository.save(member);
                result.addRecordsImported(1);
            });
            return result;
        }
    }

    @RequestMapping(
        path = "checkins",
        method = RequestMethod.POST,
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ImportResult importCheckIns(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new IOException("Empty File");
        try (
            var csv = new CSVParser(
                new InputStreamReader(file.getInputStream(), StandardCharsets.ISO_8859_1),
                CSVFormat.EXCEL.withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withIgnoreEmptyLines()
                    .withAllowMissingColumnNames()
            )
        ) {
            ImportResult result = new ImportResult();
            csv.forEach(rec -> {
                CheckInEntity checkIn = new CheckInEntity();
                checkIn.setId(rec.get("id"));
                checkIn.setDate(LocalDateTime.parse(rec.get("date"), DateTimeFormatter.ISO_DATE_TIME));
                checkIn.setMemberId(rec.get("memberId"));
                checkIn.setServiceId(rec.get("serviceId"));
                checkInRepository.save(checkIn);
                result.addRecordsImported(1);
            });
            return result;
        }
    }


}
