package Computer.model;

public class Computer {

    private int id;
    private String modelNumber;
    private String model;
    private String modelType;
    private double cost;

    /**
     * A default constructor that creates a Computer object with all values set to 0 or "".
     */
    public Computer() {
        id = 0;
        modelNumber = "";
        model = "";
        modelType = "";
        cost = 0;
    }

    /**
     * A constructor that creates a Computer object with all variables set by parameters.
     * @param id
     * @param modelNumber
     * @param modelName
     * @param modelType
     * @param cost 
     */
    public Computer(int id, String modelNumber, String modelName, String modelType, double cost) {
        this.id = id;
        this.modelNumber = modelNumber;
        this.model = modelName;
        this.modelType = modelType;
        this.cost = cost;
    }

    /**
     * This method returns the model of the computer object.
     * @return 
     */
    public String getModel() {
        return model;
    }

    /**
     * This method sets the model of the computer object.
     * @return 
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method returns the ID of the computer object.
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * This method sets the ID of the computer object.
     * @return 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method returns the model number of the computer object.
     * @return 
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * This method sets the model number of the computer object.
     * @return 
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * This method returns the model type of the computer object.
     * @return 
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * This method sets the model type of the computer object.
     * @return 
     */
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    /**
     * This method returns the cost of the computer object.
     * @return 
     */
    public double getCost() {
        return cost;
    }

    /**
     * This method sets the cost of the computer object.
     * @return 
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * This method concatinates the variables and returns them as a string.
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%5d : %s, %s, %s, %.2f", this.getId(), this.getModel(),
                this.getModelNumber(), this.getModelType(), this.getCost());
    }
}

