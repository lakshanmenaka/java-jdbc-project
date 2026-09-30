import java.sql.*;

public class StudentDAO {

    public void addStudent(Student student) {


        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";

        try {
            Connection connection = Jdbc.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try {
            Connection connection = Jdbc.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");

                System.out.println(
                        id + " | " +
                        name + " | " +
                        email + " | " +
                        age
                );
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {

    String sql = """
            UPDATE students
            SET name = ?, email = ?, age = ?
            WHERE id = ?
            """;

        try {
            Connection connection = Jdbc.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try {
            Connection connection = Jdbc.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}