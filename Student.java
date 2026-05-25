
class Student {
    int rollNo;
    String name;
    int mark1, mark2, mark3;
    int total;
    double average;
    char grade;

    Student(int rollNo, String name, int m1, int m2, int m3) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = m1;
        this.mark2 = m2;
        this.mark3 = m3;
        calculateResults();
    }

    void calculateResults() {
        total = mark1 + mark2 + mark3;
        average = total / 3.0;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 40) grade = 'D';
        else grade = 'F';
    }
}