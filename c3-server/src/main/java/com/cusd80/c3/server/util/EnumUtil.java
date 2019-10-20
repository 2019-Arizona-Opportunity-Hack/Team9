package com.cusd80.c3.server.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnumUtil {

    private static final Map<Object, Map<String, Enum<?>>> CACHE = new ConcurrentHashMap<>();

    public static <E extends Enum<E>> E fromString(Class<E> type, String value) {
        return null;
    }

}
