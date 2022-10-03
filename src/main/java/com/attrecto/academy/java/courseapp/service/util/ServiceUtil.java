package com.attrecto.academy.java.courseapp.service.util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import com.attrecto.academy.java.courseapp.model.Course;
import com.attrecto.academy.java.courseapp.model.User;
import com.attrecto.academy.java.courseapp.model.dto.MinimalCourseDto;
import com.attrecto.academy.java.courseapp.persistence.CourseRepository;
import com.attrecto.academy.java.courseapp.persistence.UserRepository;

@Component
public class ServiceUtil {
	private CourseRepository courseRepository;
	private UserRepository userRepository;

	public ServiceUtil(final CourseRepository courseRepository, final UserRepository userRepository) {
		this.courseRepository = courseRepository;
		this.userRepository = userRepository;
	}

	public Course findCourseById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isEmpty()) {
			throw new NotFoundException(String.format("Course cannot be found with id: %s", id));
		}
		return course.get();
	}

	public User findUserById(Integer id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("User cannot be found with id: %s", id)));
	}

	public List<MinimalCourseDto> listUserCourses(User user) {
		return user.getCourses().stream().map(course -> {
			MinimalCourseDto minimalCourseDto = new MinimalCourseDto();
			minimalCourseDto.setId(course.getId());
			minimalCourseDto.setTitle(course.getTitle());
			minimalCourseDto.setDescription(course.getDescription());
			minimalCourseDto.setUrl(course.getUrl());

			return minimalCourseDto;
		}).collect(Collectors.toList());
	}
	//A kapott string alapján szűrjön a felhasználók nevére úgy hogy a ne tegyen 
	//különbséget kis és nagybetűk között
	//A visszadott felhasználókat név és id szerint növekvő sorrendbe rendezze
	public List<User> findUsersByNameFilterASCNameASCid(Integer id, String filter) {
	    User exampleUser = new User();
	    exampleUser.setName(filter);
	    ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher
	    		.matchingAny().withMatcher("name", 
	    				ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
	    Example<User> example = Example.of(exampleUser, caseInsensitiveExampleMatcher);
		final Sort sortingRules = Sort.by(Sort.Direction.ASC,"name")
				.and(Sort.by(Sort.Direction.ASC,"id"));
		final List<User> users = userRepository.findAll(example, sortingRules);
		return users;
	}
}
