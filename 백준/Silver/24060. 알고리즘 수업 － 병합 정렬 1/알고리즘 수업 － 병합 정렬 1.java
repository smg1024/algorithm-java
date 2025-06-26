import java.util.*;
import java.io.*;

public class Main {
    
    // init global variables
    static int[] A, temp;
    static int count = 0;
    static int result = -1;
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // init variables
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        temp = new int[N];
        merge_sort(A, 0, N - 1);
        
        System.out.println(result);
    }
    
    private static void merge_sort(int[] A, int low, int high) {
        if(count > K) return;    // result is calculated
        
        if(low < high) {
            int mid = (low + high) / 2;
            merge_sort(A, low, mid);
            merge_sort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }
    
    private static void merge(int[] A, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int t = 0;
        
        while(left <= mid && right <= high) {
            if(A[left] <= A[right]) {
                temp[t++] = A[left++];
            } else {
                temp[t++] = A[right++];
            }
        }
        // right sort finished first
        while(left <= mid) temp[t++] = A[left++];
        // left sort finished first
        while(right <= high) temp[t++] = A[right++];
        
        left = low;
        t = 0;
        while(left <= high) {
            count++;
            if(count == K) {
                result = temp[t];
                break;
            }
            A[left++] = temp[t++];
        }
    }
}