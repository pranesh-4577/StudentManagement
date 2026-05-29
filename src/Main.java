public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController(10);
        StudentView view = new StudentView();

        

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