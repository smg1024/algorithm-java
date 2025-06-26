import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // init variables
        Queue<Integer> pQueue = new LinkedList();
        Queue<Integer> nQueue = new LinkedList();
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            
            // divide pos & neg inputs
            if(input < 0) nQueue.add(input);
            else pQueue.add(input);
        }
        
        int[] pArr = new int[pQueue.size()];
        int[] nArr = new int[nQueue.size()];
        
        for(int i = 0; i < pArr.length; i++) {
            pArr[i] = pQueue.poll();
        }
        for(int i = 0; i < nArr.length; i++) {
            nArr[i] = nQueue.poll();
        }
        
        // implementation
        // perform radix sort
        pArr = radixSort(pArr);
        nArr = radixSort(nArr);
        
        // build the sorted arrays
        StringBuilder sb = new StringBuilder();
        
        // negative array
        for(int i = nArr.length - 1; i >= 0; i--) {
            sb.append(nArr[i]).append("\n");
        }
        // positive array
        for(int i = 0; i < pArr.length; i++) {
            sb.append(pArr[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    private static int[] radixSort(int[] arr) {
        int[] sortArr = new int[arr.length];
        int maxRadix = 0;
        
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        // calculate max radix of input number
        for(int l : arr) {
            int radix = (int) Math.log10(Math.abs(l)) + 1;
            if(maxRadix < radix) maxRadix = radix;
        }
        
        // init Map
        for(int i = 0; i < 10; i++) {
            map.put(i, new LinkedList<Integer>());
        }
        
        // repeat for maxRadix
        for(int i = 0; i < maxRadix; i++) {
            for(int j = 0; j < 10; j++) {
                map.get(j).clear();
            }
            
            for(int j = arr.length - 1; j >= 0; j--) {    // why start from end?
                int sortingNum = arr[j];
                int targetQueueKey = (int) (Math.abs(sortingNum) / Math.pow(10, i) % 10);
                map.get(targetQueueKey).add(sortingNum);
            }
            
            // poll from queues
            int sortIdx = arr.length - 1;
            for(int j = 9; j >= 0; j--) {
                int queSize = map.get(j).size();
                for(int qIdx = 0; qIdx < queSize; qIdx++) {
                    sortArr[sortIdx--] = map.get(j).poll();
                }
            }
            
            System.arraycopy(sortArr, 0, arr, 0, arr.length);
        }
        return arr;
    }
}