package com.example.tutorial.protos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.github.eulerlcs.hello.api.proto.addressbook.Person;
import com.google.protobuf.util.JsonFormat;


class PersonTest {

	@Test
	void writeToTest() throws Exception {
		Person.PhoneNumber.Builder phoneBuilder = Person.PhoneNumber.newBuilder();
		phoneBuilder.setNumber("123-456-789").setType(Person.PhoneType.HOME);

		Person.Builder personBuilder = Person.newBuilder();
		personBuilder
			.setId(1234)
			.setName("野村 研一")
			.setEmail("kenichi@example.com")
			.addPhones(phoneBuilder);

		Person person =personBuilder.build();

		writeToProto(person);
//		writeToXml(person);
		writeToJson(person);
	}

	@Test
	void readProtoTest() throws Exception {
		String filename = "./john.data";

		Person.Builder personBuilder = Person.newBuilder();

		personBuilder.mergeFrom(new FileInputStream(filename));

		Person john = personBuilder.build();
		System.out.println(john);
	}


	private void writeToProto(Person john) throws IOException {
		String filename = "./john.data";
		FileOutputStream output = new FileOutputStream(filename);

		john.writeTo(output);

		output.close();
	}


	void writeToJson(Person john) throws IOException {
		String filename = "./john.json";
		FileOutputStream output = new FileOutputStream(filename);

		String jsonString = JsonFormat.printer().print(john);

		output.write(jsonString.getBytes());

		output.close();
	}
}
