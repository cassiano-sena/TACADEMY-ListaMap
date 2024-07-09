import java.util.*;
import java.util.stream.*;
public class Student {
    private String name;
    private double grade;
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
    public static List<String> getStudentsWithMoreThan(Map<String, Student> students, double grade) {
        return students.values().stream()
                .filter(student -> student.getGrade() > grade)
                .map(Student::getName)
                .collect(Collectors.toList());
    }
    public static List<Student> removeStudentsWithLessThan(Map<String, Student> students, double grade) {
        List<Student> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Student>> iterator = students.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            if (entry.getValue().getGrade() < grade) {
                removed.add(entry.getValue());
                iterator.remove();
            }
        }
        return removed;
    }
    public static Map<String, Student> rankStudentsByGrade(Map<String, Student> students) {
        return students.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getGrade(), e1.getValue().getGrade()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
    public static Map<String, List<Student>> groupStudentsByGrade(Map<String, Student> students) {
        Map<String, List<Student>> group = new HashMap<>();
        group.put("Best", new ArrayList<>());
        group.put("Great", new ArrayList<>());
        group.put("Good", new ArrayList<>());
        group.put("Okay", new ArrayList<>());
        group.put("Underperformer", new ArrayList<>());
        for (Student student : students.values()) {
            if (student.getGrade() >= 90) {
                group.get("Best").add(student);
            } else if (student.getGrade() >= 80) {
                group.get("Great").add(student);
            } else if (student.getGrade() >= 70) {
                group.get("Good").add(student);
            } else if (student.getGrade() >= 60) {
                group.get("Okay").add(student);
            } else {
                group.get("Underperformer").add(student);
            }
        }
        return group;
    }
}
