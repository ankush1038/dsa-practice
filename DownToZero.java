import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'downToZero' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    static class Pair{
        int first;
        int second;

        public Pair(int a,int b){
            first = a;
            second = b;
        }
    }

    public static int downToZero(int n) {
        // Write your code here
        Queue<Pair> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(new Pair(n, 0));
        visited.add(n);

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int num = curr.first;
            int moves = curr.second;

            if(num == 0) return moves;

            if(!visited.contains(num-1)){
                queue.add(new Pair(num-1, moves+1));
                visited.add(num-1);
            }

            for(int i=2 ; i*i <= num ; i++){
                if(num % i == 0){
                    int a = i;
                    int b = num/i;

                    int maxAB = Math.max(a,b); //max factor

                    if(!visited.contains(maxAB)){
                        queue.add(new Pair(maxAB, moves+1));
                        visited.add(maxAB);
                    }
                }
            }
        }

        return -1;

    }

}

public class DownToZero {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result1.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
