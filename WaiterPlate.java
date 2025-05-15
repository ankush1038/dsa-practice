import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result0 {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> A = new Stack<>();

        for (int i = 0; i < number.size(); i++) {
            A.push(number.get(i));
        }

        int prime = 2;
        for (int i = 0; i < q; i++) {
            Stack<Integer> nextA = new Stack<>();
            Stack<Integer> B = new Stack<>();

            while (!A.isEmpty()) {
                int val = A.pop();
                if (val % prime == 0) {
                    B.push(val);
                } else {
                    nextA.push(val);
                }
            }

            while (!B.isEmpty()) {
                result.add(B.pop());
            }

            A = nextA;
            prime = nextPrime(prime);
        }

        while (!A.isEmpty()) {
            result.add(A.pop());
        }

        return result;
    }

    private static int nextPrime(int num) {
        num++;
        while (true) {
            boolean isPrime = true;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) return num;
            num++;
        }
    }

}

public class WaiterPlate {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result0.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}