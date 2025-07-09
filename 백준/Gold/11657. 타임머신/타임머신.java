import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;

class Bus {
    int end, time;
    
    Bus(int end, int time) {
        this.end = end;
        this.time = time;
    }
}

public class Main {
    // init global variables
    static int N, M;
    static ArrayList<ArrayList<Bus>> edges;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        dist = new long[N + 1];
        for(int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
            dist[i] = INF;
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            edges.get(A).add(new Bus(B, C));
        }
        
        StringBuilder sb = new StringBuilder();
        if(bellmanFord()) {
            sb.append("-1\n");
        } else {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE) sb.append("-1\n");
                else sb.append(dist[i]).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // implementation
    private static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;
        
        for(int i = 1; i < N; i++) {    // repeat (N-1) times
            update = false;
            
            for(int j = 1; j <= N; j++) {
                for(Bus next : edges.get(j)) {
                    if(dist[j] == INF) break;    // cannot update distance
                    
                    if(dist[next.end] > dist[j] + next.time) {    // update distance
                        dist[next.end] = dist[j] + next.time;
                        update = true;
                    }
                }
            }
            
            if(!update) break;    // finish loop when no update happens
        }
        
        // determine negative cycle for Nth time
        if(update) {
            for(int i = 1; i <= N; i++) {
                for(Bus next : edges.get(i)) {
                    if(dist[i] == INF) break;
                    
                    if(dist[next.end] > dist[i] + next.time) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}