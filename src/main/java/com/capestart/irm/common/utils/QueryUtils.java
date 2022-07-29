package com.capestart.irm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QueryUtils {
    public static String convertObjToString(Object obj) {
        if (null == obj) {
            return "";
        }
        return String.valueOf(obj);
    }

    public static Integer convertObjToInteger(Object obj) {
        if (null == obj) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(obj));
    }

    public static String getSearchKey(String key) {
        if (null == key || key.isEmpty()) {
            return "%%";
        }
        return "%" + key + "%";
    }

    public static String getSearchDate(Date date) {
        if (null == date) {
            return "%%";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}
