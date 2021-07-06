package com.github.eulerlcs.hello.application.tryProto;

import java.util.Map;

import com.github.eulerlcs.hello.api.proto.baeldung.BaeldungTraining.Course;

public class CourseRepository {
	Map<Integer, Course> courses;

	public CourseRepository(Map<Integer, Course> courses) {
		this.courses = courses;
	}

	public Course getCourse(int id) {
		return courses.get(id);
	}
}
