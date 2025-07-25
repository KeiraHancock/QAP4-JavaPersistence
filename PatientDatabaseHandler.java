import java.sql.*;

public class PatientDatabaseHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/qap4db";
    private static final String USER = "keyin";
    private static final String PASSWORD = "admin";

    public static void savePatientToDatabase(Patient patient) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO patients (id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getFirstName());
            stmt.setString(3, patient.getLastName());
            stmt.setDate(4, java.sql.Date.valueOf(patient.getDob()));
            stmt.executeUpdate();
            System.out.println("Patient saved to database.");
        } catch (SQLException e) {
            System.out.println("Error saving to database: " + e.getMessage());
        }
    }

    public static void readPatientsFromDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM patients");

            System.out.println("\n--- Patient Data from Database ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ", " +
                    rs.getString("first_name") + ", " +
                    rs.getString("last_name") + ", " +
                    rs.getString("dob")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error reading from database: " + e.getMessage());
        }
    }
}
