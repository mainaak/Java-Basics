package polymorphism;

public class Cars {

    protected String drivetrain;
    protected String model;
    protected Integer year;

    public Cars(String drivetrain, String model, Integer year) {
        this.drivetrain = drivetrain;
        this.model = model;
        this.year = year;
    }

    public Cars() {

    }

    public String toString() {
        return String.format("Drivetrain: " + drivetrain + "\tModel: " + model + "\tYear: " + year);
    }
}
