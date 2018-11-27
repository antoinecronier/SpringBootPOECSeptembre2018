package com.example.demo.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.example.demo.utils.AES;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
	private static final String KEY = "Bar12345Bar12345"; // 128 bit key
	private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV

	public String convertToDatabaseColumn(String ccNumber) {
		try {
			return AES.encrypt(KEY, INIT_VECTOR, ccNumber).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String convertToEntityAttribute(String dbData) {
		try {
			return AES.decrypt(KEY, INIT_VECTOR, dbData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
