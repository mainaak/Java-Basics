package fileHandling;

public class Cars {
    private String car;
    private String model;
    private String year;

    public Cars(String car, String model, String year) {
        this.car = car;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return String.format("Car: " + car + "\tModel: " + model + "\tYear: " + year);
    }
}
