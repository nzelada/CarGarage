package NickZelada;

import java.io.*;
import java.util.*;
import NickZelada.Car;
import NickZelada.Garage;

/**
 * The Test class consist of the main in which would run the program.
 *
 * @author Nick Zelada
 * @version September 19, 2018
 */



public class Test {

    /**
     * It would read the garage.txt file. It would go into the while loop and
     * see if its either ACTION or DEPART. Depending on which one, it would
     * return the result from Garage.java from the corresponding methods. After
     * that, it would print out an output.txt file in which will has the printed
     * results.
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Garage newG = new Garage();
        String outputResult = "";

        Scanner in = new Scanner(new File("garage.txt"));
        PrintWriter toFile = new PrintWriter("output.txt");
        while (in.hasNext()) {
            String license = in.next();
            String action = in.next();
            Car next = new Car(license);
            if (action.equalsIgnoreCase("ARRIVE")) {
                //Taking function result in a variable to print it in the file
                outputResult = newG.arrive(next);
                toFile.println(outputResult);           //Writing into output file
            } else if (action.equalsIgnoreCase("DEPART")) {
                //Taking function result in a variable to print it in the file
                outputResult = newG.depart(next);
                toFile.println(outputResult);           //Writing into output file
            }

        }
        System.out.println();
        toFile.close();

    }
}
