import java.sql.*;

public class PatientDAO {

    public void addPatient(Patient patient){
        String sql = "INSERT INTO patient VALUES(?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,patient.getId());
            stmt.setString(2,patient.getName());
            stmt.setString(3,patient.getCNIC());
            stmt.executeUpdate();
            System.out.println("Patient Added Successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patient WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE employee SET name=?, CNIC=?, WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getCNIC());
            stmt.setInt(4, patient.getId());
            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void viewAllPatient() {
        String sql = "SELECT * FROM patient";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", CNIC: " + rs.getString("CNIC"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Patient searchPatientById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("CNIC"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
