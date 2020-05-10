package fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class FileHandling {
    Cars[] cars = new Cars[4];
    Scanner scanner;

    private Formatter formatter;

    public void createFile() throws FileNotFoundException {
        formatter = new Formatter("ReadFile.txt");
    }

    public void addEntry(String cars, String model, String year) {
        formatter.format(cars + " " + model + " " + year + "\n");
    }

    public void closeFile() {
        formatter.close();
    }

    public void openFile() throws FileNotFoundException {
        scanner = new Scanner(new File("ReadFile.txt"));
    }

    public void readFile() {
        int counter = 0;
        while (scanner.hasNext()) {
            cars[counter] = new Cars(scanner.next(), scanner.next(), scanner.next());
            counter++;
        }
    }

    public void printCars() {
        for (Cars a : cars) {
            System.out.println(a);
        }
    }
}
