package com.ci1802.springbootemployeemule.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ci1802.springbootemployeemule.model.enumclass.Sex;

/**
 * The Class SexConverter. This class will convert employee attribute sex into database column SEX representation.
 *
 * @author HiepLV
 */
@Converter(autoApply = true)
public class SexConverter implements AttributeConverter<Sex, String> {

    @Override
    public String convertToDatabaseColumn(Sex sex) {
        return sex.getValue();
    }

    @Override
    public Sex convertToEntityAttribute(String sexDb) {
        for (Sex status : Sex.values()) {
            if (status.getValue().equals(sexDb)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown value " + sexDb);
    }
}