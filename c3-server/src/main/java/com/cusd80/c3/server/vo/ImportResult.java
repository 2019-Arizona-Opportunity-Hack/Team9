package com.cusd80.c3.server.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImportResult {

    private long recordsImported = 0;

    public void addRecordsImported(int add) {
        recordsImported += add;
    }

}
