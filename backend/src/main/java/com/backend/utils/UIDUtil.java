package com.backend.utils;

import java.util.UUID;

/**
 * Created by Lxy on 2023/6/25 10:29
 */
public class UIDUtil {

    public static String getUUID(int length) {
        return UUID
                .randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, length);
    }

    public static String getUUNumber(int length) {
        String current = String.valueOf(System.currentTimeMillis());
        return current.substring(current.length() - length);
    }
}
