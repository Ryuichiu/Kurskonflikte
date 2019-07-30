import java.util.*;

public class PlainExample {
    public static void main(String[] args) {
        Map<String, List<String>> studentCourses = new HashMap<>();

        List<String> courses = new ArrayList<>();
        List<String> students = new ArrayList<>();

        //add n courses
        for (int i = 'a'; i <= 'j'; i++)
            courses.add(String.valueOf((char) i));

        //add m students
        for (int i = 'A'; i <= 'F'; i++)
            students.add(String.valueOf((char) i));

        //make sets
        Random r = new Random();
        for (String student : students) {
            Collections.shuffle(courses);
            List<String> currentCourses = new ArrayList<>();
            for (int i = 1 + r.nextInt(4); i > 0; i--) {
                currentCourses.add(courses.get(i));
            }
            Collections.sort(currentCourses);
            studentCourses.put(student, currentCourses);
        }

        Collections.sort(courses);

        //get conflicts
        for (String course : courses) {
            Set<String> set = new HashSet<>();
            for (String key : studentCourses.keySet()) {
                List<String> list = studentCourses.get(key);
                if (list.contains(course))
                    set.addAll(list);
            }
            set.remove(course);
            System.out.printf("Course: %s%n%s%n", course, set);
        }
    }
}
