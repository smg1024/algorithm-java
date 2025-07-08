import java.util.*;
import java.io.*;

// define Node class
class Node {
    int destination;
    int distance;

    Node(int destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }
}

public class Main {
    // init global variables
    static ArrayList<Node>[] adjArr;
    static int V, E, K;
    static int[] D;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        adjArr = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        D = new int[V + 1];
         
        for(int i = 1; i <= V; i++) {
            adjArr[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adjArr[u].add(new Node(v, w));
        }
        
        // implementation
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        D[K] = 0;
        queue.add(new Node(K, 0));
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(!visited[current.destination]) visited[current.destination] = true;
            
            for(Node next : adjArr[current.destination]) {
                if(!visited[next.destination] && current.distance + next.distance < D[next.destination]) {
                    D[next.destination] = current.distance + next.distance;
                    queue.add(new Node(next.destination, D[next.destination]));
                }
            }
        }
        
        for(int i = 1; i <= V; i++) {
            if(D[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(D[i]);
        }
    }
}