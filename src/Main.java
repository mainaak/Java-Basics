import fileHandling.FileHandling;
import gui.ButtonGui;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        //new ButtonGui();
        FileHandling fileHandling = new FileHandling();
        fileHandling.createFile();
        fileHandling.addEntry("Mercedes-Benz","C63","2018");
        fileHandling.addEntry("Honda","City","2009");
        fileHandling.addEntry("VW","Vento","2014");
        fileHandling.closeFile();
        fileHandling.openFile();
        fileHandling.readFile();
        fileHandling.printCars();
    }
}