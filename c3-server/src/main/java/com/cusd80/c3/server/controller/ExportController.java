package com.cusd80.c3.server.controller;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.cusd80.c3.api.ExportApi;
import com.cusd80.c3.server.repo.CheckInRepository;
import com.cusd80.c3.server.repo.MemberRepository;
import com.cusd80.c3.server.repo.ServiceRepository;

@RestController
@Transactional
@RequestMapping("export")
public class ExportController implements ExportApi {

    public static final String CSV_VALUE = "test/csv";
    public static final MediaType CSV = MediaType.parseMediaType(CSV_VALUE);

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CheckInRepository checkInRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> exportRedirect() {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, "export.html").build();
    }

    @RequestMapping(path = "services.csv", method = RequestMethod.GET, produces = CSV_VALUE)
    public ResponseEntity<StreamingResponseBody> exportServices() {
        return ResponseEntity.ok().contentType(CSV).body(out -> {
            try (
                var csv = new CSVPrinter(
                    new OutputStreamWriter(out, StandardCharsets.ISO_8859_1),
                    CSVFormat.EXCEL.withHeader("id", "name", "order", "enabled")
                )
            ) {
                for (var rec : serviceRepository.findAll()) {
                    csv.printRecord(rec.getId(), rec.getName(), rec.getSortOrder(), rec.isEnabled());
                }
            }
        });
    }

    @RequestMapping(path = "members.csv", method = RequestMethod.GET, produces = CSV_VALUE)
    public ResponseEntity<StreamingResponseBody> exportMembers() {
        return ResponseEntity.ok().contentType(CSV).body(out -> {
            try (
                var csv = new CSVPrinter(
                    new OutputStreamWriter(out, StandardCharsets.ISO_8859_1),
                    CSVFormat.EXCEL.withHeader(
                        "id",
                        "parentId",
                        "type",
                        "firstName",
                        "lastName",
                        "birthDate",
                        "address1",
                        "address2",
                        "city",
                        "state",
                        "zipCode",
                        "phoneNumber",
                        "gender",
                        "maritalStatus",
                        "housingType",
                        "ethnicity",
                        "selfIdentify",
                        "educationLevel",
                        "language",
                        "employmentType",
                        "incomeTypes",
                        "incomeAmount",
                        "insuranceType",
                        "hasPrimaryCareProvider",
                        "hasDentalInsurance",
                        "childCareType",
                        "specialNeeds",
                        "school",
                        "updateDate"
                    )

                )
            ) {
                for (var rec : memberRepository.findAll()) {
                    csv.printRecord(
                        rec.getId(),
                        rec.getParentId(),
                        rec.getType(),
                        rec.getFirstName(),
                        rec.getLastName(),
                        rec.getBirthDate(),
                        rec.getAddress1(),
                        rec.getAddress2(),
                        rec.getCity(),
                        rec.getState(),
                        rec.getZipCode(),
                        rec.getPhoneNumber(),
                        rec.getGender(),
                        rec.getMaritalStatus(),
                        rec.getHousingType(),
                        rec.getEthnicity(),
                        rec.getSelfIdentify(),
                        rec.getEducationLevel(),
                        rec.getLanguage(),
                        rec.getEmploymentType(),
                        StringUtils.join(
                            rec.getIncomeTypes().stream().map(Object::toString).collect(Collectors.toList()),
                            '|'
                        ),
                        rec.getIncomeAmount(),
                        rec.getInsuranceType(),
                        rec.getHasPrimaryCareProvider(),
                        rec.getHasDentalInsurance(),
                        rec.getChildCareType(),
                        rec.getSpecialNeeds(),
                        rec.getSchool(),
                        rec.getUpdateDate()
                    );
                }
            }
        });
    }

    @RequestMapping(path = "checkins.csv", method = RequestMethod.GET, produces = CSV_VALUE)
    public ResponseEntity<StreamingResponseBody> exportCheckIns() {
        return ResponseEntity.ok().contentType(CSV).body(out -> {
            try (
                var csv = new CSVPrinter(
                    new OutputStreamWriter(out, StandardCharsets.ISO_8859_1),
                    CSVFormat.EXCEL.withHeader("id", "date", "memberId", "serviceId")
                )
            ) {
                for (var rec : checkInRepository.findAll()) {
                    csv.printRecord(rec.getId(), rec.getDate(), rec.getMemberId(), rec.getServiceId());
                }
            }
        });
    }

}
