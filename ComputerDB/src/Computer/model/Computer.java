package Computer.model;

public class Computer {

    private int id;
    private String modelNumber;
    private String model;
    private String modelType;
    private double cost;

    public Computer() {
        id = 0;
        modelNumber = "";
        model = "";
        modelType = "";
        cost = 0;
    }

    public Computer(int id, String modelNumber, String modelName, String modelType, double cost) {
        this.id = id;
        this.modelNumber = modelNumber;
        this.model = modelName;
        this.modelType = modelType;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int geId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("%5d : %s, %s, %s, %.2f", this.geId(), this.getModel(),
                this.getModelNumber(), this.getModelType(), this.getCost());
    }
}