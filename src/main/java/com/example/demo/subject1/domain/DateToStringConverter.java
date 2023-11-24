package com.example.demo.subject1.domain;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateToStringConverter implements AttributeConverter<String, Date> {

    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convertToDatabaseColumn(String attribute) {

        Date date = null;
        try {
            date = sf.parse(attribute);
        } catch (ParseException e) {
            log.error("[DateToStringConverter] Date parse error : {}", e.getMessage());
        }

        return date;
    }

    @Override
    public String convertToEntityAttribute(Date dbData) {
        if(dbData != null) {
            return sf.format(dbData);
        }else {
            return null;
        }
    }
}
