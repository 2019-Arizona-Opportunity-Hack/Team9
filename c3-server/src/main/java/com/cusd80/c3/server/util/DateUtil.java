package com.cusd80.c3.server.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate parseDate(String str) {
        LocalDate date = null;
        if (date == null) try {
            date = LocalDate.parse(str);
        } catch (Exception ignore) {
        }
        if (date == null) try {
            date = LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
        } catch (Exception ignore) {
        }
        if (date == null) try {
            date = LocalDate.parse(str, DateTimeFormatter.ofPattern("M/d/yyyy"));
        } catch (Exception ignore) {
        }
        if (date == null) try {
            date = LocalDate.parse(str, DateTimeFormatter.ofPattern("M/d/yy"));
        } catch (Exception ignore) {
        }
        return date;
    }

    public static LocalDateTime parseDateTime(String str) {
        LocalDateTime dateTime = null;
        if (dateTime == null) try {
            dateTime = LocalDateTime.parse(str);
        } catch (Exception ignore) {
        }
        if (dateTime == null) try {
            dateTime = ZonedDateTime.parse(str).toLocalDateTime();
        } catch (Exception ignore) {
        }
        return dateTime;
    }

}
