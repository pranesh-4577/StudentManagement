
import java.sql.*;

class StudentController {

    StudentController(int size) {

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String createTableSQL =
                    "CREATE TABLE IF NOT EXISTS students (" +
                    "rollNo INT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "mark1 INT, " +
                    "mark2 INT, " +
                    "mark3 INT, " +
                    "total INT, " +
                    "average DOUBLE, " +
                    "grade CHAR(1))";

            stmt.executeUpdate(createTableSQL);

            conn.close();

        } catch (Exception e) {
            System.out.println("Table setup error: " + e.getMessage());
        }
    }

    // CREATE
    void addStudent(int rollNo, String name, int m1, int m2, int m3) {

        Student temp = new Student(rollNo, name, m1, m2, m3);

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql =
                    "INSERT INTO students VALUES (" +
                    temp.rollNo + ", '" +
                    temp.name + "', " +
                    temp.mark1 + ", " +
                    temp.mark2 + ", " +
                    temp.mark3 + ", " +
                    temp.total + ", " +
                    temp.average + ", '" +
                    temp.grade + "')";

            stmt.executeUpdate(sql);

            System.out.println("Student Added Successfully");

            conn.close();

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // READ ALL
    Student[] getStudents() {

        int totalCount = getCount();

        Student[] studentsList = new Student[totalCount];

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            int index = 0;

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("rollNo"),
                        rs.getString("name"),
                        rs.getInt("mark1"),
                        rs.getInt("mark2"),
                        rs.getInt("mark3")
                );

                studentsList[index++] = s;
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }

        return studentsList;
    }

    // COUNT
    int getCount() {

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT COUNT(*) AS total FROM students");

            if (rs.next()) {

                int total = rs.getInt("total");

                conn.close();

                return total;
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error getting count: " + e.getMessage());
        }

        return 0;
    }

    // SEARCH
    Student findStudent(int rollNo) {

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs =
                    stmt.executeQuery(
                            "SELECT * FROM students WHERE rollNo = " + rollNo);

            if (rs.next()) {

                Student s = new Student(
                        rs.getInt("rollNo"),
                        rs.getString("name"),
                        rs.getInt("mark1"),
                        rs.getInt("mark2"),
                        rs.getInt("mark3")
                );

                conn.close();

                return s;
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Error searching student: " + e.getMessage());
        }

        return null;
    }

    // UPDATE
    void updateStudent(int rollNo,
                       String name,
                       int m1,
                       int m2,
                       int m3) {

        Student temp = new Student(rollNo, name, m1, m2, m3);

        try {

            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql =
                    "UPDATE students SET " +
                    "name='" + temp.name + "', " +
                    "mark1=" + temp.mark1 + ", " +
                    "mark2=" + temp.mark2 + ", " +
                    "mark3=" + temp.mark3 + ", " +
                    "total=" + temp.total + ", " +
                    "average=" + temp.average + ", " +
                    "grade='" + temp.grade + "' " +
                    "WHERE rollNo=" + temp.rollNo;

            int rows = stmt.executeUpdate(sql);

            if (rows > 0)
                System.out.println("Student Updated Successfully");
            else
                System.out.println("Student Not Found");

            conn.close();

        } catch (Exception e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    // DELETE
    void deleteStudent(int rollNo) {

        try {

            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sql =
                    "DELETE FROM students WHERE rollNo=" + rollNo;

            int rows = stmt.executeUpdate(sql);

            if (rows > 0)
                System.out.println("Student Deleted Successfully");
            else
                System.out.println("Student Not Found");

            conn.close();

        } catch (Exception e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }
}

