package classOrganiser;

public class ConditionalOperators extends Variables {

    public ConditionalOperators() {
        value[0] = 0;
        value[1] = 0;
    }

    public void compareMethod() {
        System.out.println("Enter value1: ");
        value[0] = input.nextInt();
        System.out.println("Enter value2: ");
        value[1] = input.nextInt();

        System.out.println(value[0] > value[1] ? greaterMethod() : smallerMethod());
        System.out.println("\n\n\n");
    }

    public String greaterMethod() {
        return "value1 is greater";
    }

    public String smallerMethod() {
        return "value2 is greater";
    }
}
