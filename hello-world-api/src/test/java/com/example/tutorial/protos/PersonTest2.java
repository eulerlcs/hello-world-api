package com.example.tutorial.protos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.github.eulerlcs.hello.api.proto.addressbook.Person;
import com.googlecode.protobuf.format.JsonFormat;
import com.googlecode.protobuf.format.XmlFormat;

class PersonTest2 {
private final static int COUNT = 1;

	@Test
	void writeToTest() throws Exception {
		Person.PhoneNumber.Builder phoneBuilder = Person.PhoneNumber.newBuilder();
		phoneBuilder.setNumber("123-456-789").setType(Person.PhoneType.HOME);

		Person.Builder personBuilder = Person.newBuilder();
		personBuilder
			.setId(1234)
			.setName("野村 研一郎")
			.setEmail("kenichi@example.com")
			.addPhones(phoneBuilder);

		Person person =personBuilder.build();

		System.out.println(person.getSerializedSize());
		System.out.println(person.toString());

		writeToProto(person);
		writeToXml(person);
		writeToJson(person);
	}

	@Test
	void readProtoTest() throws Exception {
		String filename = "./john.data";

		Person.Builder personBuilder = Person.newBuilder();

		// Read the existing address book.
		try {
			personBuilder.mergeFrom(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			System.out.println(filename + ": File not found.  Creating a new file.");
		}

		Person john = personBuilder.build();
		System.out.println(john);
	}


	private void writeToProto(Person john) throws IOException {
		String filename = "./john.data";
		FileOutputStream output = new FileOutputStream(filename);

		LocalDateTime t1 = LocalDateTime.now();

		for(int i = 0; i < COUNT; i++) {
			john.writeTo(output);
		}

		LocalDateTime t2 = LocalDateTime.now();
		long nanos = t1.until(t2,ChronoUnit.NANOS);
		System.out.println("proto(nanos):" + nanos);

		output.close();
	}

	void writeToXml(Person john) throws IOException {
		String filename = "./john.xml";
		FileOutputStream output = new FileOutputStream(filename);

		XmlFormat fomater = new XmlFormat();

		LocalDateTime t1 = LocalDateTime.now();

		for(int i = 0; i < COUNT; i++) {
			fomater.print(john, output);
		}

		LocalDateTime t2 = LocalDateTime.now();
		long nanos = t1.until(t2,ChronoUnit.NANOS);
		System.out.println("xml(nanos):" + nanos);

		output.close();
	}

	void writeToJson(Person john) throws IOException {
		String filename = "./john.json";
		FileOutputStream output = new FileOutputStream(filename);

		JsonFormat fomater = new JsonFormat();

		LocalDateTime t1 = LocalDateTime.now();

		for(int i = 0; i < COUNT; i++) {
			fomater.print(john, output);
		}

		LocalDateTime t2 = LocalDateTime.now();
		long nanos = t1.until(t2,ChronoUnit.NANOS);
		System.out.println("json(nanos):" + nanos);

		output.close();
	}

}
