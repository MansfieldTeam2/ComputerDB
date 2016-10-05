package Computer.model;

public class Computer {

    private int number;
    private String modelNumber;
    private String model;
    private String modelType;
    private double cost;

    public Computer() {
        number = 0;
        modelNumber = "";
        model = "";
        modelType = "";
        cost = 0;
    }

    public Computer(int number, String modelNumber, String modelName, String modelType, double cost) {
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        return String.format("%5d : %s, %s, %s, %.2f", this.getNumber(), this.getModel(),
                this.getModelNumber(), this.getModelType(), this.getCost());
    }
}

