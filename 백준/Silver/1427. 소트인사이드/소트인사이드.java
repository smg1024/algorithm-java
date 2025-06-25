import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // init variables
        String N = sc.next();
        int[] arr = new int[N.length()];
        for(int i = 0; i < N.length(); i++) {
            arr[i] = Integer.parseInt(N.substring(i, i+1));
        }
        
        // implementation
        for(int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if(arr[i] < arr[maxIndex]) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
        
        // print result
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}