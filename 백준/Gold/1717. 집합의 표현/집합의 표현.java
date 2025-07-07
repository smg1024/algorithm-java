import java.util.*;
import java.io.*;

public class Main {
    // init global variables
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int action = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // implementation
            switch(action) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    validate(a, b);
                    break;
            }
        }
    }
    
    private static void union(int a, int b) {
        int aTop = findTopNode(a);
        int bTop = findTopNode(b);
        
        arr[bTop] = aTop;
    }
    
    private static int findTopNode(int node) {
         return (arr[node] == node) ? node : findTopNode(arr[node]);
    }
    
    private static void validate(int a, int b) {
        if(findTopNode(a) == findTopNode(b))
            System.out.println("YES");
        else System.out.println("NO");
    }
}