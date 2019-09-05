package com.ci1802.springbootemployeemule.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ci1802.springbootemployeemule.model.enumclass.HrStatus;


@Converter(autoApply=true)
public class HrStatusConverter implements AttributeConverter<HrStatus,String>{

	@Override
	public String convertToDatabaseColumn(HrStatus HrStatus) {
		// TODO Auto-generated method stub
		return HrStatus.getValue();
	}

	@Override
	public HrStatus convertToEntityAttribute(String hrStatusDb) {
		for (HrStatus hrstatus : HrStatus.values()) {
            if (hrstatus.getValue().equals(hrStatusDb)) {
                return hrstatus;
            }
        }
        throw new IllegalArgumentException("Unknown value " + hrStatusDb);
	}
	
}
