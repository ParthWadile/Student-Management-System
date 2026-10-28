import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean running = true;

        System.out.println("================================");
        System.out.println("     JAVA BASICS PROJECT");
        System.out.println("      Student Management");
        System.out.println("================================");

        while (running) {
            System.out.println("\\n1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Calculate average marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("ID must be a whole number.");
                        sc.nextLine();
                        break;
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter marks (0 to 100): ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Marks must be a number.");
                        sc.nextLine();
                        break;
                    }
                    double marks = sc.nextDouble();
                    sc.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        break;
                    }

                    manager.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    manager.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("ID must be a whole number.");
                        sc.nextLine();
                        break;
                    }
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    manager.searchStudent(searchId);
                    break;

                case 4:
                    manager.showAverageMarks();
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 5.");
            }
        }

        sc.close();
    }
}
