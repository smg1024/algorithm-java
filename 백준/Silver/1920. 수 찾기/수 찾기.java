import java.util.*;
import java.io.*;

public class Main {
    // init global variables
    static int N;
    static int[] A;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        
        // implementation
        Arrays.sort(A);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int result = 0;
            int start = 0, end = A.length - 1;    // 0 ~ 9
            
            while(start <= end) {
                int median = (start + end) / 2;    // 4
                int medianValue = A[median];
                if(medianValue > target) {
                    end = median - 1;
                } else if(medianValue < target) {
                    start = median + 1;
                } else {
                    result = 1;
                    break;
                }
            }
            
            System.out.println(result);
        }
    }
}