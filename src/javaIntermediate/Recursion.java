package javaIntermediate;

public class Recursion {

    public Recursion() {
        System.out.println(factorial(5));
    }

    public static int factorial(Integer number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(--number);
    }

    int number = 1;
    int factorial = 1;

    public int factorial() {
        while (number <= 5 && number >= 1) {
            factorial *= number++;
        }
        return factorial;
    }
}
