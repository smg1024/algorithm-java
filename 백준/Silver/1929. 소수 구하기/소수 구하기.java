import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // init variables
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int[] num = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            num[i] = i;
        }
        num[1] = 0;
        
        // implementation
        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(num[i] == 0) continue;
            for(int j = 2 * i; j <= N; j += i) {
                num[j] = 0;
            }
        }
        
        for(int i = M; i <= N; i++) {
            if(num[i] != 0) 
                System.out.println(num[i]);
        }
    }
}