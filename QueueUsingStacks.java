import java.io.*;
import java.util.*;

public class QueueUsingStacks {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        for(int i=0; i<q ; i++){
            int number = sc.nextInt();

            if(number == 1){
                int n = sc.nextInt();
                inputStack.push(n);
            } else if(number == 2){
                if(outputStack.isEmpty()){
                    while(!inputStack.isEmpty()){
                        outputStack.push(inputStack.pop());
                    }
                }
                if(!outputStack.isEmpty()){
                    outputStack.pop();
                }
            } else if(number == 3){
                if(outputStack.isEmpty()){
                    while(!inputStack.isEmpty()){
                        outputStack.push(inputStack.pop());
                    }
                }
                if(!outputStack.isEmpty()){
                    System.out.println(outputStack.peek());
                }
            }
        }
    }
}