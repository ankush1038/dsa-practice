// Brute Force

//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//public class Solution {
//
//    // Complete the countTriplets function below.
//    static long countTriplets(List<Long> arr, long r) {
//        int count = 0;
//        int n = arr.size();
//
//        for(int i=0; i< n-2; i++){
//            for(int j=0; j<n-1; j++){
//                if(arr.get(j) == arr.get(i)*r){
//                    for(int k=0; k<n; k++){
//                        if(arr.get(k) == arr.get(j)*r){
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(nr[0]);
//
//        long r = Long.parseLong(nr[1]);
//
//        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Long::parseLong)
//                .collect(toList());
//
//        long ans = countTriplets(arr, r);
//
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
