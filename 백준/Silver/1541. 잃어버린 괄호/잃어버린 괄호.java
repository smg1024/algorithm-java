import java.util.*;

public class Main {
    // init global variable;
    static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // init variable
        String equation = sc.nextLine();
        String[] arr = equation.split("-");
        
        for(int i = 0; i < arr.length; i++) {
            int calc = calcSum(arr[i]);
            if(i == 0) answer += calc;
            else answer -= calc;
        }
        
        System.out.println(answer);
    }
    
    private static int calcSum(String sum) {
        int result = 0;
        String[] nums = sum.split("[+]");
        for(String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}