import java.util.Scanner;

class StudentView {
    Scanner sc = new Scanner(System.in);

    void showMenu() {
        System.out.println("\n--- Student Grade Management ---");
        System.out.println("1. Display Students");
        System.out.println("2. Search Student");
        System.out.println("3. Exit");
    }

    int getChoice() {
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    void displayStudents(Student[] students, int count) {
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            System.out.println(s.rollNo + " - " + s.name +
                    " | Total: " + s.total +
                    " | Avg: " + s.average +
                    " | Grade: " + s.grade);
        }
    }

    int getRollNo() {
        System.out.print("Enter Roll No: ");
        return sc.nextInt();
    }

    void showMessage(String msg) {
        System.out.println(msg);
    }
}