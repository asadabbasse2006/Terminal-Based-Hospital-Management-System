import java.sql.*;

public class StaffDAO {

    public void addStaff(Staff staff){
        String sql = "INSERT INTO staff VALUES(?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,staff.getId());
            stmt.setString(2,staff.getName());
            stmt.setString(3,staff.getTime());
            stmt.executeUpdate();
            System.out.println("Staff Added Successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean deleteStaff(int id) {
        String sql = "DELETE FROM staff WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affected = stmt.executeUpdate();
            System.out.println("Staff Deleted successfully");
            return affected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE employee SET name=?, CNIC=?, WHERE id=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, staff.getName());
            stmt.setString(2, staff.getTime());
            stmt.setInt(4, staff.getId());
            int affected = stmt.executeUpdate();
            System.out.println("Patient Updated successfully");
            return affected > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void viewAllStaff() {
        String sql = "SELECT * FROM staff";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", CNIC: " + rs.getString("time"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Staff searchStaffById(int id) {
        String sql = "SELECT * FROM staff WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Staff(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("time"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
