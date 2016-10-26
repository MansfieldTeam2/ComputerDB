package Computer.viewui;
import Validator.util.Validator;
import java.util.Scanner;
import Computer.model.Computer;
import Computer.model.IComputerDAO;
import Computer.model.datastore.mysql.ComputerDAO;

public class ComputerApp {

    IComputerDAO myList = new ComputerDAO();
    Scanner sc = new Scanner(System.in);

    public ComputerApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String modelNumber, model, modelType;
        double cost;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nComputer App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(myList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New Computer Id: ");
                    modelNumber = Validator.getLine(sc, "Model Number: ");
                    model = Validator.getLine(sc, "Model: ");
                    modelType = Validator.getLine(sc, "Model Type: ");
                    cost = Validator.getDouble(sc, "Cost: ");
                    myList.createRecord(new Computer(id, modelNumber, model, modelType, cost));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Computer Number to retrieve: ");
                    System.out.println(myList.retrieveRecordById(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Computer Number to update: ");
                    modelNumber = Validator.getLine(sc, "Model Number: ");
                    model = Validator.getLine(sc, "Model: ");
                    modelType = Validator.getLine(sc, "Model Type: ");
                    cost = Validator.getDouble(sc, "Cost: ");
                    myList.updateRecord(new Computer(id, modelNumber, model, modelType, cost));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Computer Number to delete: ");
                    System.out.println(myList.retrieveRecordById(id));
                    String ok = Validator.getLine(sc, "Delete this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        myList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ComputerApp();
    }
}
