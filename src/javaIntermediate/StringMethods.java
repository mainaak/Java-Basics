package javaIntermediate;

import java.util.Scanner;

public class StringMethods {
    public StringMethods(String starting, String ending){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many strings do you wish to enter?");
        String[] strings = new String[Integer.parseInt(scanner.nextLine())];
        Integer counter = 0;
        for (String s : strings){
            System.out.println("Enter string "+ (counter+1));
            strings[counter] = scanner.nextLine();
            counter++;
        }

        String[] a = startsWith(strings,starting);

        String[] filteredString = endsWith(a,ending);

        for (String f : filteredString ){
            System.out.println(f);
        }
    }

    private String[] startsWith(String[] startsWith, String starting){
        String[] useItForStart = new String[startsWith.length];
        Integer counter = 0;
        for (String b : startsWith){
            if (b.startsWith(starting)){
                useItForStart[counter++] = b;
            }
        }
        String[] noNull = new String[counter];
        counter = 0;
        for (String nn : useItForStart){
            if (nn!=null) {
                noNull[counter++] = nn;
            }
        }

        return noNull;
    }

    private String[] endsWith(String[] endsWith, String ending){
        String[] useItForEnd = new String[endsWith.length];
        Integer counter = 0;
        for (String b : endsWith){

            if (b.endsWith(ending)){
                useItForEnd[counter++] = b;
            }
        }
        return useItForEnd;
    }
}
