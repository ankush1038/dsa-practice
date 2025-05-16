import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
//import static java.util.stream.Collectors.joiniAng;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'poisonousPlants' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int poisonousPlants(List<Integer> p) {
        // Write your code here
        int days = 0;
        boolean died = true;

        while(died){
            died = false;
            List<Integer> nextDay = new ArrayList<>();
            nextDay.add(p.get(0));

            for(int i=1; i<p.size(); i++){
                if(p.get(i) <= p.get(i-1)){
                    nextDay.add(p.get(i));
                } else {
                    died = true;
                }
            }
            if(died){
                days++;
            }
            p = nextDay;
        }
        return days;
    }

}

public class PoisonousPlant {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
