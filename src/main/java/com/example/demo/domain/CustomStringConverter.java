package com.example.demo.domain;

import javax.persistence.AttributeConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomStringConverter implements AttributeConverter<LocalDateTime, String>

{
    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime.toString();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
