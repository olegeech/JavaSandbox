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
        int c; //result variable
        boolean point = false;
        List<String> resultsStr = new ArrayList<String>(); //aggregated results
        int a1 = 0; //temp var

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printNewLine("Добро пожаловать в программу 'Калькулятор деления столбиком (КДС)'");
        a = input(a, bufferedReader, "Пожалуйста, введите числитель (a): ");
        b = input(b, bufferedReader, "а теперь введите знаменатель (b): ");


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

            c = (int)((double) a / b); //casted twice because of int rounding


            resultsStr.add(String.valueOf(c));
            a = a - (c * b); //excess calculation
            System.out.println(a);

            i++;
        } while (a!=0 && i < 10);

        //Print results
        for (String r : resultsStr) {
            System.out.print(r);
        }
        printNewLine("\nХорошего дня! :)");
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
                System.err.println("Неправильный формат числа. Введите целое");
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
