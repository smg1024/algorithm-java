import java.io.*;
import java.util.*;

public class Main {
    // init global variables
    static int N, K;
    static int[] coin;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        
        // implementation
        for(int i = N - 1; i >= 0; i--) {
            if(coin[i] > K) continue;
            
            count += K / coin[i];
            K %= coin[i];
        }
        
        System.out.println(count);
    }
}