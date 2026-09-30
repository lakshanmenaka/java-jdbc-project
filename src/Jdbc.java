import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_student_db";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD);
    }

    public static void main(String[] args) {

        Student student = new Student(
                "Kamal",
                "kamal@gmail.com",
                25);

        Student updateStudent = new Student(
                "Kamal",
                "kamal@gmail.com",
                25);
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.addStudent(student);

        studentDAO.getAllStudents();

        studentDAO.updateStudent(updateStudent);

        studentDAO.deleteStudent(0);

        try {

            Connection connection = getConnection();

            System.out.println("Database connected successfully!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}