
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cis2206.model.Computer;
import cis2206.model.IComputerDAO;

/**
 * ComputerDAO (Data Access Object) handles all interactions with the data
 * store. This version uses a MySQL database to store the data. It is multiuser
 * safe.
 *
 * @author Mansfield Team 2
 *
 */
public class ComputerDAO implements IComputerDAO {

    protected final static boolean DEBUG = true;

    @Override
    public void createRecord(Computer computer) {
        final String QUERY = "insert into computer "
                + "(compId, lastName, firstName, homePhone, salary) "
                + "VALUES (null, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setString(1, computer.getLastName());
            stmt.setString(2, computer.getFirstName());
            stmt.setString(3, computer.getHomePhone());
            stmt.setDouble(4, computer.getSalary());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("createRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public Computer retrieveRecordById(int id) {
        final String QUERY = "select compId, lastName, firstName, homePhone, "
                + "salary from computer where compId = " + id;
        Computer comp = null;

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            // stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            if (rs.next()) {
                comp = new Computer(
                        rs.getInt("compId"), 
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("homePhone"), 
                        rs.getDouble("salary"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveRecordById SQLException: " 
                    + ex.getMessage());
        }

        return comp;
    }

    @Override
    public List<Computer> retrieveAllRecords() {
        final List<Computer> myList = new ArrayList<>();
        final String QUERY = "select compId, lastName, firstName, homePhone, "
                + "salary from computer";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new Computer(
                        rs.getInt("compId"), 
                        rs.getString("lastName"), 
                        rs.getString("firstName"),
                        rs.getString("homePhone"), 
                        rs.getDouble("salary")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public void updateRecord(Computer updatedComputer) {
        final String QUERY = "update computer set lastName=?, firstName=?, "
                + "homePhone=?, salary=? where compId=?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setString(1, updatedComputer.getLastName());
            stmt.setString(2, updatedComputer.getFirstName());
            stmt.setString(3, updatedComputer.getHomePhone());
            stmt.setDouble(4, updatedComputer.getSalary());
            stmt.setInt(5, updatedComputer.getEmpId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("updateRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteRecord(int id) {
        final String QUERY = "delete from computer where compId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, id);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteRecord(Computer computer) {
        final String QUERY = "delete from computer where compId = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, computer.getEmpId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Computer computer : retrieveAllRecords()) {
            sb.append(computer.toString()).append("\n");
        }

        return sb.toString();
    }
}

