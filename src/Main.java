import java.util.*;
public class Main {
    public static void main(String[] args) {
        //1
        System.out.println("\n\n\n");
        System.out.println("1: ");
        Map<String, Student> students = new HashMap<>();
        students.put("Maria Joana", new Student("Maria Joana", 95));
        students.put("Bruno Farias", new Student("Bruno Farias", 100));
        students.put("Cassiano", new Student("Cassiano", 70));
        students.put("Douglas", new Student("Douglas", 80));
        students.put("Fernanda", new Student("Fernanda", 90));
        System.out.println(students);
        //2
        System.out.println("\n\n\n");
        System.out.println("2: ");
        System.out.println(getGradeFromMap(students, "Maria Joana"));
        System.out.println(getGradeFromMap(students, "Joãozinhho"));
        System.out.println(Student.getStudentsWithMoreThan(students, 85));
        //3
        System.out.println("\n\n\n");
        System.out.println("3: ");
        System.out.println(Student.removeStudentsWithLessThan(students, 80));
        //4
        System.out.println("\n\n\n");
        System.out.println("4: ");
        System.out.println(Student.rankStudentsByGrade(students));
        //5
        System.out.println("\n\n\n");
        System.out.println("5: ");
        System.out.println(Student.groupStudentsByGrade(students));
    }
    public static String getGradeFromMap(Map<String, Student> students, String name) {
        Student student = students.get(name);
        return (student != null) ? String.valueOf(student.getGrade()) : "Student not found";
    }
}
