package com.ci1802.springbootemployeemule.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ci1802.springbootemployeemule.model.enumclass.PoiType;

@Converter(autoApply = true)
public class PoiTypeConverter implements AttributeConverter<PoiType, String> {

	@Override
	public String convertToDatabaseColumn(PoiType poiType) {
		// TODO Auto-generated method stub
		return poiType.getValue();
	}

	@Override
	public PoiType convertToEntityAttribute(String poiTypeDb) {
		for (PoiType poiType : PoiType.values()) {
			if (poiType.getValue().equals(poiTypeDb)) {
				return poiType;
			}
		}
		throw new IllegalArgumentException("Unknown value " + poiTypeDb);
	}

}
