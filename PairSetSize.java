import java.io.*;
import java.util.*;

public class PairSetSize {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        Set<String> pairSet = new HashSet<>();
        for(int i=0; i<n; i++){
            String firstName = sc.next();
            String lastName = sc.next();

            String fullName = firstName + " " + lastName;
            String reversedName = lastName + " " + firstName;
            if(!pairSet.contains(reversedName))
                pairSet.add(fullName);
            System.out.println(pairSet.size());
        }
    }

}