import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String FILE_NAME = "students.txt";
    private List<Student> students = new ArrayList<>();

    public void loadStudents() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    students.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                    ));
                }
            }
        } catch (Exception e) {}
    }

    public void saveStudents() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {}
    }

    public void addStudent(Student s) {
        students.add(s);
        saveStudents();
        System.out.println("Student Added!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAge() + " - " + s.getCourse());
        }
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        saveStudents();
        System.out.println(removed ? "Deleted!" : "Student Not Found!");
    }
}
