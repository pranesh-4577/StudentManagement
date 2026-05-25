class StudentController {
    Student[] students;
    int count;

    StudentController(int size) {
        students = new Student[size];
        count = 0;
    }

    void addStudent(int rollNo, String name, int m1, int m2, int m3) {
        students[count++] = new Student(rollNo, name, m1, m2, m3);
    }

    Student[] getStudents() {
        return students;
    }

    int getCount() {
        return count;
    }

    Student findStudent(int rollNo) {
        for (int i = 0; i < count; i++) {
            if (students[i].rollNo == rollNo) {
                return students[i];
            }
        }
        return null;
    }
}

