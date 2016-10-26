package Computer.model.datastore.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Computer.model.Computer;
import Computer.model.IComputerDAO;

public class ComputerDAO implements IComputerDAO {

    protected final static boolean DEBUG = true;

    @Override
    public void createRecord(Computer computer) {
        final String QUERY = "insert into computer "
                + "(id, modelNumber, model, modelType, cost) "
                + "VALUES (null, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setString(1, computer.getModelNumber());
            stmt.setString(2, computer.getModel());
            stmt.setString(3, computer.getModelType());
            stmt.setDouble(4, computer.getCost());
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
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer where number = " + id;
        // final String QUERY = "select comId, modelNumber, model, modelType,
        // cost from computer where comId = ?";
        Computer com = null;

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            // stmt.setInt(1, number);
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            if (rs.next()) {
                com = new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"),
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveRecordByNumber SQLException: " 
                    + ex.getMessage());
        }

        return com;
    }

    @Override
    public List<Computer> retrieveAllRecords() {
        final List<Computer> myList = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public void updateRecord(Computer updatedComputer) {
        final String QUERY = "update computer set ModelNumber=?, Model=?, "
                + "modelType=?, cost=? where id=?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setString(1, updatedComputer.getModelNumber());
            stmt.setString(2, updatedComputer.getModel());
            stmt.setString(3, updatedComputer.getModelType());
            stmt.setDouble(4, updatedComputer.getCost());
            stmt.setInt(5, updatedComputer.geId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("updateRecord SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void deleteRecord(int number) {
        final String QUERY = "delete from employee where id = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, number);
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
        final String QUERY = "delete from computer where id = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, computer.geId());
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
