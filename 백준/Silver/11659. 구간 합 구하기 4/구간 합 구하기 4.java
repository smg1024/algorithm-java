import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // number of inputs
        int N = Integer.parseInt(st.nextToken());
        // calc frequency
        int M = Integer.parseInt(st.nextToken());
        
        // sum array
        long[] sum = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        // input number array
        sum[0] = 0;
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        // calc range
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            System.out.println(sum[right] - sum[left-1]);
        }
        
    }
}