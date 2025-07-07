import java.util.*;
import java.io.*;

public class Main {
    // init global variables
    static ArrayList<Integer>[] adjArr;
    static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjArr = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            adjArr[i] = new ArrayList<>();
        }
        inDegree = new int[N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjArr[a].add(b);
            inDegree[b]++;
        }
        
        // implementation
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);    // starting point selection
            }
        }
        
        while(!queue.isEmpty()) {
            int current = queue.poll();    // starting point
            System.out.printf("%d ", current);
            for(int next : adjArr[current]) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}