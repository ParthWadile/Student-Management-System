public class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;

    public boolean addStudent(Student student) {
        if (count >= students.length) {
            System.out.println("Student list is full.");
            return false;
        }

        if (findById(student.getId()) != null) {
            System.out.println("A student with this ID already exists.");
            return false;
        }

        students[count] = student;
        count++;
        System.out.println("Student added successfully.");
        return true;
    }

    public void showAllStudents() {
        if (count == 0) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("\\n--- Student List ---");
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }

    public Student findById(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public void searchStudent(int id) {
        Student student = findById(id);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.display();
        }
    }

    public void showAverageMarks() {
        if (count == 0) {
            System.out.println("Add students first to calculate the average.");
            return;
        }

        double total = 0;
        for (int i = 0; i < count; i++) {
            total += students[i].getMarks();
        }

        double average = total / count;
        System.out.printf("Average marks: %.2f%n", average);
    }
}
