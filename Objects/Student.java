package Objects;

import java.util.*;

public class Student {
   private String name;
   private Set<Course> courses = new TreeSet<>();

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    void addCourse(Course course) {
        courses.add(course);
    }

    Set<Course> getCourses() {
        return courses;
    }
}
