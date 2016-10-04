package Computer.model;
import java.util.List;
/**
 *
 * @author hero
 */

public interface IComputerDAO {

    void createRecord(Computer computer);

    Computer retrieveRecordById(int id);

    List<Computer> retrieveAllRecords();

    void updateRecord(Computer updatedComputer);

    void deleteRecord(int id);

    void deleteRecord(Computer computer);

    @Override
    String toString();

}