/**
 * Created by Oleg on 21.08.2014.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** Long devision calculator */

public class LongDivisionCalculator {
    public static void main(String[] args) throws IOException {
        int a = 0; //input variable
        int b = 0; //input variable
        int c = 0; //result variable
        boolean point = false;
        List<String> resultsStr = new ArrayList<String>(); //aggregated results

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printNewLine("Welcome to long devision calculator");
        a = input(a, bufferedReader, "Please enter numerator (a): ");
        b = input(b, bufferedReader, "Please enter de-numerator (b): ");


        printNewLine(a+" | "+b);

        int i = 0;
        do {
            //if numerator less then de-numerator
            int i1 = 0;
            while (a<b) {
                if (i1 > 0) {resultsStr.add(String.valueOf(0));}
                if (!point){resultsStr.add("."); point = true;}
                a *= 10;
                i1++;
            }
            System.out.println(a);

            while (a >= b) {
                //int iSpace;
                a -= b;
                c++;
            }
            resultsStr.add(String.valueOf(c));
            c = 0;

            i++;
        } while (a!=0 && i < 10);

        //Print results
        for (String r : resultsStr) {
            System.out.print(r);
        }
        printNewLine("\nHave a nice day! :)");
    }

    private static void printNewLine(String text) {
        System.out.println(text);
    }

    private static int input(int i, BufferedReader br, String inputText) throws IOException {
        System.out.print(inputText);
        boolean isError = true;
        while (isError) {
            try{
                i = Integer.parseInt(br.readLine());
                isError = false;
            }catch(NumberFormatException nfe){
                System.err.println("Inappropriate number format. Please use integer");
                isError = true;
            }
        }
        return i;
    }


}



/* try to implement devision without devision

do {
        int numLength = (int)(Math.log10(a)+1);
        System.out.println("a numLength: " +numLength);

        for(numLength = (int)(Math.log10(a)+1); numLength>0; numLength--){
        a = a/10;
        System.out.println("a do cancat: " +a);

        }
        } while (a1>=0);*/
