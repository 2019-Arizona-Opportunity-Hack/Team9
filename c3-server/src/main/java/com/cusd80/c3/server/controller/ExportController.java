package com.cusd80.c3.server.controller;

import static com.cusd80.c3.server.C3ServerConstants.CSV;
import static com.cusd80.c3.server.C3ServerConstants.CSV_VALUE;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.cusd80.c3.server.repo.ServiceRepository;

@RestController
@RequestMapping("export")
public class ExportController {

    @Autowired
    private ServiceRepository serviceRepository;

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

}
