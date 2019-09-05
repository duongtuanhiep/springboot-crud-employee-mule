//package com.ci1802.springbootemployeemule.converter;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
//import com.ci1802.springbootemployeemule.model.enumclass.MainSecType;
//
//@Converter(autoApply = true)
//public class MainSecTypeConverter implements AttributeConverter<MainSecType, String> {
//
//    @Override
//    public String convertToDatabaseColumn(MainSecType mainSecType) {
//        return mainSecType.getValue();
//    }
//
//    @Override
//    public MainSecType convertToEntityAttribute(String sexDb) {
//        for (MainSecType status : MainSecType.values()) {
//            if (status.getValue().equals(sexDb)) {
//                return status;
//            }
//        }
//        throw new IllegalArgumentException("Unknown value " + sexDb);
//    }
//}