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

    /**
     * This method creates a record within the database using the parameters input by the user.
     * @param computer 
     */
    @Override
    public void createRecord(Computer computer) {
        final String QUERY = "insert into computer "
                + "(id, modelNumber, model, modelType, cost) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY);) {
            stmt.setInt(1, computer.getId());
            stmt.setString(2, computer.getModelNumber());
            stmt.setString(3, computer.getModel());
            stmt.setString(4, computer.getModelType());
            stmt.setDouble(5, computer.getCost());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("createRecord SQLException: " + ex.getMessage());
        }
    }

    /**
     * This method returns a record based upon the ID entered by the user.
     * @param id
     * @return 
     */
    @Override
    public Computer retrieveRecordById(int id) {
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer where id = " + id;
        // final String QUERY = "select Id, modelNumber, model, modelType,
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

    /**
     * This method returns all records in the database and displays them.
     * @return 
     */
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

    /**
     * This method allows the user to change an existing record.
     * @param updatedComputer 
     */
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
            stmt.setInt(5, updatedComputer.getId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("updateRecord SQLException: " + ex.getMessage());
        }
    }

    /**
     * This method allows the user to delete a record by ID.
     * @param id 
     */
    @Override
    public void deleteRecord(int id) {
        final String QUERY = "delete from computer where id = ?";

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

    /**
     * This method allows the user to delete a record by ID.
     * @param id 
     */
    @Override
    public void deleteRecord(Computer computer) {
        final String QUERY = "delete from computer where id = ?";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            stmt.setInt(1, computer.getId());
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("deleteRecord SQLException: " + ex.getMessage());
        }
    }
    
    /**
     * This method returns all records in the database and displays them in descending order by ID.
     * @return 
     */
    @Override
    public List<Computer> retrieveAllRecordsDesc() {
        final List<Computer> myList2 = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList2.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecordsDesc SQLException: " + ex.getMessage());
        }

        return myList2;
    }
    
    /**
     * This method returns all records in the database and displays them sorted alphabetically by model.
     * @return 
     */
    @Override
    public List<Computer> retrieveAllRecordsByModel() {
        final List<Computer> myList3 = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer ORDER BY model";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList3.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecordsDesc SQLException: " + ex.getMessage());
        }

        return myList3;
    }
    
    /**
     * This method returns all records in the database and sorts them by model number.
     * @return 
     */
    @Override
    public List<Computer> retrieveAllRecordsByModelNumber() {
        final List<Computer> myList3 = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer ORDER BY modelNumber";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList3.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecordsDesc SQLException: " + ex.getMessage());
        }

        return myList3;
    }
    
    /**
     * This method returns all records in the database and displays them sorted alphabetically by model type.
     * @return 
     */
    @Override
    public List<Computer> retrieveAllRecordsByModelType() {
        final List<Computer> myList3 = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer ORDER BY modelType";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList3.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecordsDesc SQLException: " + ex.getMessage());
        }

        return myList3;
    }
    
    /**
     * This method returns all records in the databsse sorted by cost.
     * @return 
     */
    @Override
    public List<Computer> retrieveAllRecordsByCost() {
        final List<Computer> myList3 = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer ORDER BY cost";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList3.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecordsDesc SQLException: " + ex.getMessage());
        }

        return myList3;
    }
    
    /**
     * This method returns records in the form of a string.
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Computer computer : retrieveAllRecords()) {
            sb.append(computer.toString()).append("\n");
        }

        return sb.toString();
		
	}
}
