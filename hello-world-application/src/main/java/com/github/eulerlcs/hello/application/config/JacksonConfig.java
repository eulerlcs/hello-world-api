package com.github.eulerlcs.hello.application.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

@Configuration
public class JacksonConfig {
	@Value("${kpl.jackson.local-date-format}")
	private String DEFAULT_DATE_FORMAT;
	@Value("${kpl.jackson.local-time-format}")
	private String DEFAULT_TIME_FORMAT;
	@Value("${kpl.jackson.local-datetime-format}")
	private String DEFAULT_DATE_TIME_FORMAT;

	@Bean
	public Converter<String, LocalDate> localDateConverter() {
		return new Converter<>() {
			@Override
			public LocalDate convert(String source) {
				return LocalDate.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
			}
		};
	}

	/**
	 * LocalDateTime Converter， for converting RequestParam and PathVariable
	 * parameters
	 */
	@Bean
	public Converter<String, LocalDateTime> localDateTimeConverter() {
		return new Converter<>() {
			@Override
			public LocalDateTime convert(String source) {
				return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
			}
		};
	}

	/**
	 * LocalTime Converter， for converting RequestParam and PathVariable parameters
	 */
	@Bean
	public Converter<String, LocalTime> localTimeConverter() {
		return new Converter<>() {
			@Override
			public LocalTime convert(String source) {
				return LocalTime.parse(source, DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
			}
		};
	}

	/**
	 * Date Converter， for converting RequestParam and PathVariable parameters
	 */
	@Bean
	public Converter<String, Date> dateConverter() {
		return new Converter<>() {
			@Override
			public Date convert(String source) {
				SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
				try {
					return format.parse(source);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		};
	}

	/**
	 * Json Serializer and Deserializer
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

		// LocalDateTime Serializer and Deserializer ，inherit from jsr310
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class,
				new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addSerializer(LocalDate.class,
				new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
		javaTimeModule.addSerializer(LocalTime.class,
				new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDateTime.class,
				new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT)));
		javaTimeModule.addDeserializer(LocalDate.class,
				new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));
		javaTimeModule.addDeserializer(LocalTime.class,
				new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT)));

		// Date Serializer and Deserializer
		javaTimeModule.addSerializer(Date.class, new JsonSerializer<>() {
			@Override
			public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
					throws IOException {
				SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
				String formattedDate = formatter.format(date);
				jsonGenerator.writeString(formattedDate);
			}
		});
		javaTimeModule.addDeserializer(Date.class, new JsonDeserializer<>() {
			@Override
			public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
					throws IOException, JsonProcessingException {
				SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
				String date = jsonParser.getText();
				try {
					return format.parse(date);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		});

		objectMapper.registerModule(javaTimeModule);
		return objectMapper;
	}
}
