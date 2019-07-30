package Objects;

public class Course implements Comparable<Course>{
    private String name;

    Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Course o) {
        return o.name.compareTo(this.name);
    }
}
