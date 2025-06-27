import java.util.*;
import java.io.*;

public class Main {
    // init global variables
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};    // search direction in x/y direction: N S W E
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(token.substring(j, j + 1));
            }
        }
        
        // implementation
        BFS(0, 0);
        
        System.out.println(A[N-1][M-1]);
    }
    
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});    // starting coordinate
        visited[i][j] = true;    // starting point visited check
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            
            for(int d = 0; d < 4; d++) {    // start searching 4 directions
                int x = now[0] + dx[d];
                int y = now[1] + dy[d];
                if(x >= 0 && y >= 0 && x < N && y < M) {    // inside grid
                    if(A[x][y] != 0 && !visited[x][y]) {    // not 0, not visited
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;    // depth calc
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}