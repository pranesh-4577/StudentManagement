public class Main {

    public static void main(String[] args) {

        StudentController controller =
                new StudentController(10);

        StudentView view =
                new StudentView();

        while (true) {

            view.showMenu();

            int choice = view.getChoice();

            switch (choice) {

                case 1:

                    Student newStudent =
                            view.getStudentDetails();

                    controller.addStudent(
                            newStudent.rollNo,
                            newStudent.name,
                            newStudent.mark1,
                            newStudent.mark2,
                            newStudent.mark3);

                    break;

                case 2:

                    view.displayStudents(
                            controller.getStudents(),
                            controller.getCount());

                    break;

                case 3:

                    int searchRoll =
                            view.getRollNo();

                    Student s =
                            controller.findStudent(searchRoll);

                    if (s != null)
                        view.showMessage(
                                "Found: " +
                                s.name +
                                " | Grade: " +
                                s.grade);
                    else
                        view.showMessage("Student Not Found");

                    break;

                case 4:

                    Student updateStudent =
                            view.getStudentDetails();

                    controller.updateStudent(
                            updateStudent.rollNo,
                            updateStudent.name,
                            updateStudent.mark1,
                            updateStudent.mark2,
                            updateStudent.mark3);

                    break;

                case 5:

                    int deleteRoll =
                            view.getRollNo();

                    controller.deleteStudent(deleteRoll);

                    break;

                case 6:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}