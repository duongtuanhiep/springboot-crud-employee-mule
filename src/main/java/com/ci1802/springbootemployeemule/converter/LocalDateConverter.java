package com.ci1802.springbootemployeemule.converter;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * The Class LocalDateConverter. This class will convert entity with type LocalDate into database column representation and vice versa.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.toLocalDate();
    }

}

