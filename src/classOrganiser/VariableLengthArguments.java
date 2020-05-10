package classOrganiser;

public class VariableLengthArguments extends Variables{

    Integer[] integerArray;

    public VariableLengthArguments(){
        setValues(1,3,2,1,2,3,5,6);
    }

    public void setValues(Integer...inputs){
        initialize = 0;
        integerArray = new Integer[inputs.length];
        for (Integer receivedInputs : inputs){
        integerArray[initialize] = receivedInputs;
        ++initialize;
        }
    }

    public Integer getValues(int index){
        return integerArray[index];
    }

    public Integer[] getValues(){
        return integerArray;
    }

    public String toString(){
        return String.format("%d",integerArray);
    }
}