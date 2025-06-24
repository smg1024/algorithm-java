import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // variables
        int n = sc.nextInt();    // length
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        
        // implementation
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            int current = arr[i];
            if(current >= num) {
                while(current >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int popped = stack.pop();
                if(popped > current) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if(result) System.out.println(sb.toString());
    }
}