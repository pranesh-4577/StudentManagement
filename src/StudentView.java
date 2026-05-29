import java.util.Scanner;

class StudentView {

    Scanner sc = new Scanner(System.in);

    void showMenu() {

        System.out.println("\n--- Student Grade Management ---");

        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    int getChoice() {

        System.out.print("Enter choice: ");
        return sc.nextInt();
    }

    Student getStudentDetails() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mark1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter Mark2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter Mark3: ");
        int m3 = sc.nextInt();

        return new Student(roll, name, m1, m2, m3);
    }

    void displayStudents(Student[] students, int count) {

        System.out.println("\n--- Student List ---");

        for (int i = 0; i < count; i++) {

            Student s = students[i];

            System.out.println(
                    s.rollNo + " - " +
                    s.name +
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