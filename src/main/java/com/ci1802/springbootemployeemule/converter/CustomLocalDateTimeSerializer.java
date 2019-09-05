package com.ci1802.springbootemployeemule.converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    /** The Constant DATE_TIME_PATTERN. */
    public static final String PATTERN_DATE_TIME = "yyyyMMddHHmmss";

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator generator, SerializerProvider sp) throws IOException, JsonProcessingException {
        String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern(PATTERN_DATE_TIME));
        generator.writeString(formattedDateTime);
    }
}