import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // goal number
        int N = sc.nextInt();
        // index
        int start = 1;
        int end = 1;
        // count and sum
        int count = 1;
        int sum = 1;
        
        while(end != N) {
            if(sum == N) {
                count++;
                sum += ++end;
            } else if(sum > N) {
                sum -= start++;
            } else if(sum < N) {
                sum += ++end;
            }
        }
        
        System.out.println(count);
    }
}