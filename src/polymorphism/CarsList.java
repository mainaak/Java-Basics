package polymorphism;

import java.util.LinkedList;
import java.util.List;

public class CarsList {
    List<Cars> carsList = new LinkedList<>();

    public void addIntoTheList(Cars cars){
        carsList.add(cars);
    }

    public List<Cars> getCarsList(){
        return carsList;
    }
}
