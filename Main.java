import Objects.School;

public class Main {
    public static void main(String[] args) {
        School school = new School(10);
        school.makeSets();
        school.getConflicts().forEach((course, conflicts) -> System.out.printf("Course: %S%n%s%n", course, conflicts));
    }
}
