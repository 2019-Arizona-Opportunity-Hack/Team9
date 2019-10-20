package com.cusd80.c3.server;

import org.springframework.http.MediaType;

public interface C3ServerConstants {
    public static final String CSV_VALUE = "test/csv";
    public static final MediaType CSV = MediaType.parseMediaType(CSV_VALUE);
}
