import java.io.*;
import java.util.*;

public class Main {
    // init global variables
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[N + 1];    // adjacent node list
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();    // init ArrayList arrays
            visited[i] = false;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            A[left].add(right);
            A[right].add(left);    // bidirectional
        }
        
        // implementation
        int count = 0;
        for(int i = 1; i < N + 1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        
        System.out.println(count);
    }
    
    private static void DFS(int node) {
        if(visited[node]) return;    // already visited node
        
        visited[node] = true;
        for(int nextNode : A[node]) {
            if(!visited[nextNode]){
                DFS(nextNode);
            }
        }
    }
}