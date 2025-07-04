import java.util.*;
import java.io.*;

public class Main {
    // define global variable
    static int K;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static boolean[] set;
    static boolean isEven;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // init variables
        K = Integer.parseInt(br.readLine());
        for(int test = 0; test < K; test++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            A = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            set = new boolean[V + 1];
            visited = new boolean[V + 1];
            isEven = true;
            
            // implementation
            for(int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                A[start].add(end);
                A[end].add(start);
            }
            
            for(int i = 1; i <= V; i++) {
                if(isEven) {
                    DFS(i);
                } else {
                    break;
                }
            }
            
            if(isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    private static void DFS(int start) {
        visited[start] = true;
        for(int dest : A[start]) {
            if(!visited[dest]) {    // first time visit
                set[dest] = !set[start];
                DFS(dest);
            } else if(set[start] == set[dest]) {
                isEven = false;
            }
        }
    }
}