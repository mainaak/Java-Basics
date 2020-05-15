import polymorphism.*;

public class Main {

    public static void main(String args[]) {
        Cars cars = new Cars();

        CarsList carsListObject = new CarsList();
        carsListObject.addIntoTheList(new Honda("FWD","City",2009));
        carsListObject.addIntoTheList(new Volkswagen("FWD","Polo",2025));
        carsListObject.addIntoTheList(new Mercedes("AWD","G55 AMG",2025));
        carsListObject.addIntoTheList(new BMW("RWD","530D MSport",2022));

        System.out.println(cars.toString());
        System.out.println(carsListObject.getCarsList());
    }
}