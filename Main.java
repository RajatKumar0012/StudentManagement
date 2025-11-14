import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadStudents();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                manager.addStudent(new Student(id, name, age, course));
            }
            else if (ch == 2) {
                manager.viewStudents();
            }
            else if (ch == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                manager.deleteStudent(id);
            }
            else if (ch == 4) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
