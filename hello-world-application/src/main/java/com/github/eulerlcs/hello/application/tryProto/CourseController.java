package com.github.eulerlcs.hello.application.tryProto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.eulerlcs.hello.api.proto.baeldung.BaeldungTraining.Course;

//@Slf4j
@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	CourseRepository courseRepo;

	// consumes="application/x-protobuf", produces="application/x-protobuf"
	@GetMapping(value = "/courses/{id}")
	Course customer(@PathVariable Integer id) {
		return courseRepo.getCourse(id);
	}
}
