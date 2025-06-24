import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // initialize variables
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
            // priority rules
            // absolute values of a and b
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            
            // 1. negative number comes first
            if(absA == absB) {
                return a > b ? 1 : -1;
            }
            
            // 2. small absolute value number comes first
            return absA - absB;
        });
        
        // implementation
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if(queue.isEmpty()) System.out.println("0");
                else System.out.println(queue.poll());
            } else {
                queue.add(input);
            }
        }
    }
}