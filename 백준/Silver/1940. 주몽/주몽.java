import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // material
        int num = Integer.parseInt(br.readLine());
        int[] material = new int[num];
        // goal number
        int goal = Integer.parseInt(br.readLine());
        
        // material input array
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(material);
        
        // calc
        int count = 0;
        int left = 0;    // min
        int right = num - 1;    // max
        
        while(left < right) {
            if (material[left] + material[right] < goal) left++;
            else if (material[left] + material[right] > goal) right--;
            else {
                count++;
                right--;
                left++;
            }
        }
        
        System.out.println(count);
    }
}