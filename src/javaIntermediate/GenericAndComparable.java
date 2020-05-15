package javaIntermediate;

public class GenericAndComparable {

    public GenericAndComparable(){
        System.out.println(findMax("5","7","6"));
    }

    private <T extends Comparable<T>> T findMax(T firstValue, T secondValue, T thirdValue){
        T maximumValue = firstValue;

        if (firstValue.compareTo(secondValue) < 0)
            maximumValue = secondValue;

        if (thirdValue.compareTo(maximumValue) > 0)
            maximumValue = thirdValue;

        return maximumValue;
    }
}
