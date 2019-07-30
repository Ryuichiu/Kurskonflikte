package Objects;

import java.util.*;

public class School {
    private Map<Student, Set<Course>> studentCourses = new HashMap<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private int maxCurrentStudentCourses;

    public School(int maxCourses) {
        int maxStudents = (int)Math.ceil(maxCourses * 0.6);
        maxCurrentStudentCourses = (int)Math.ceil(maxStudents / 3 * 2);

        for (int i = 'A'; i < 'A' + maxStudents; i++)
            students.add(new Student(String.valueOf((char)i)));
        for (int i = 'a'; i < 'a' + maxCourses; i++)
            courses.add(new Course(String.valueOf((char)i)));
    }

    public void makeSets() {
        Random r = new Random();
        for (Student student : students) {
            Collections.shuffle(courses);
            for (int i = 1 + r.nextInt(maxCurrentStudentCourses); i > 0; i--) {
                student.addCourse(courses.get(i));
            }
            studentCourses.put(student, student.getCourses());
        }
    }

    public Map<Course, Set<Course>> getConflicts() {
        Map<Course, Set<Course>> map = new TreeMap<>(Comparator.reverseOrder());

        for (Course course : courses) {
            Set<Course> set = new TreeSet<>(Comparator.reverseOrder());
            for (Student key : studentCourses.keySet()) {
                Set<Course> list = studentCourses.get(key);
                if (list.contains(course))
                    set.addAll(list);
            }
            set.remove(course);
            map.put(course, set);
        }

        return map;
    }
}
