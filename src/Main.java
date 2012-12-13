import java.util.*;

/**
 * 
 */

/**
 * @author mizuno_ta
 * 
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> result = FizzBuzz.fizzbuzz(100);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
