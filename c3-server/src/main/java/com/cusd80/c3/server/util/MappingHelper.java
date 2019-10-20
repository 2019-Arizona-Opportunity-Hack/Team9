package com.cusd80.c3.server.util;

public class MappingHelper {

    public static String enumValue(Object theEnum)
    {
        if (theEnum == null)
        {
            return null;
        }
        else
        {
            return theEnum.toString();
        }
    }

}
