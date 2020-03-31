package com.zh.learn.common.utils;


import com.google.gson.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ZhouHu
 * @Class Name GsonUtils
 * @Desc Gson utils class
 * @create: 2020-03-19 16:40
 **/
public class GsonUtils {
    private GsonUtils() {

    }

    public static Gson getInstance(String dateFormat, ZoneId zoneId) {

        JsonDeserializer<ZonedDateTime> jsonDeserializer = (json, type, jsonDeserializationContext) -> {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(dateFormat).withZone(zoneId);
            return ZonedDateTime.parse(json.getAsString(), fmt);
        };
        JsonSerializer<ZonedDateTime> jsonSerializer = (src, typeOfSrc, context) -> {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(dateFormat);
            return new JsonPrimitive(src.format(fmt));
        };
        return getGsonBuilder().registerTypeAdapter(ZonedDateTime.class, jsonDeserializer)
                .registerTypeAdapter(ZonedDateTime.class, jsonSerializer).create();

    }

    public static Gson getInstance(String dateFormat) {
        return getInstance(dateFormat, ZoneId.systemDefault());
    }
    
    public static Gson getInstance() {
        return getInstance("yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static GsonBuilder getGsonBuilder() {
        return new GsonBuilder();
    }
}
