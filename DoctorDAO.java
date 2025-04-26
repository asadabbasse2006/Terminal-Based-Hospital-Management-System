import java.sql.*;

public class DoctorDAO {
    void addDoctor(Doctor doctor){
        String sql = "INSERT INTO doctor VALUES (?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,doctor.getId());
            stmt.setString(2,doctor.getName());
            stmt.executeUpdate();
            System.out.println("Doctor Added Successfully");
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    Doctor searchDoctor(int id){
        String sql = "SELECT * FROM doctor WHERE ID = ?";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Doctor(rs.getInt("ID"),rs.getString("Name"));
            }
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public static void viewAllDoctor() {
        String sql = "SELECT * FROM doctor";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    boolean updateDoctor(Doctor doctor){
        String sql = "UPDATE DOCTOR SET name = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,doctor.getId());
            stmt.setString(2,doctor.getName());
            int affected = stmt.executeUpdate();
            return  affected > 0;
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    boolean deleteDoctor(int id){
        String sql = "DELETE FROM doctor WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            int affected = stmt.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
