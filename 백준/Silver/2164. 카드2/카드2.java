import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // variables
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int result;
        
        // implementation
        while(queue.size() > 1) {
            // 1. discard top card
            queue.poll();
            
            // 2. move next card to bottom
            int toBottom = queue.poll();
            queue.add(toBottom);
        }
        
        System.out.println(queue.peek());
    }
}