package classOrganiser;

public enum Enumerator {

    Vento("Volkswagen", "Diesel", "Sedan"),
    City("Honda", "Petrol", "Sedan"),
    FiveSeries("BMW", "Diesel", "Coupe"),
    GLC("Mercedes-Benz","Diesel","SUV"),
    Macan("Porsche","Petrol","SUV"),
    GT2RS("Porsche","Petrol","Sports");

    private String car;
    private String fuelType;
    private String carType;
    ;

    Enumerator(String car, String fuelType, String carType) {
        this.car = car;
        this.fuelType = fuelType;
        this.carType = carType;
    }

    public String getCar(){
        return car;
    }

    public String getFuelType(){
        return fuelType;
    }

    public String getCarType(){
        return carType;
    }
}
