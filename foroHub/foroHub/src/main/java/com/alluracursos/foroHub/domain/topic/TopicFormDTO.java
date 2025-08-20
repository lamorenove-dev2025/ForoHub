package com.alluracursos.foroHub.domain.topic;

import com.alluracursos.foroHub.domain.course.Course;
import com.alluracursos.foroHub.domain.course.CourseRepository;
import com.alluracursos.foroHub.domain.user.User;
import com.alluracursos.foroHub.domain.user.UserRepository;
import jakarta.validation.constraints.NotBlank;

public record TopicFormDTO (
        @NotBlank String title,
        @NotBlank String message,
        @NotBlank String authorName,
        @NotBlank String courseName){
    public Topic convert(CourseRepository courseRepository, UserRepository userRepository) {
        User author = userRepository.findByName(authorName).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findByName(courseName).orElseThrow(() -> new IllegalArgumentException("Course not found"));
        return new Topic(title, message, course, author);
    }
}
