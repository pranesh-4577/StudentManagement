public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController(10);
        StudentView view = new StudentView();

        // Sample Students
        controller.addStudent(1, "Arun", 85, 90, 80);
        controller.addStudent(2, "Bala", 70, 65, 60);
        controller.addStudent(3, "Chitra", 95, 92, 88);

        while (true) {
            view.showMenu();
            int choice = view.getChoice();

            switch (choice) {
                case 1:
                    view.displayStudents(controller.getStudents(), controller.getCount());
                    break;

                case 2:
                    int roll = view.getRollNo();
                    Student s = controller.findStudent(roll);
                    if (s != null)
                        view.showMessage("Found: " + s.name + " | Grade: " + s.grade);
                    else
                        view.showMessage("Student Not Found");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

