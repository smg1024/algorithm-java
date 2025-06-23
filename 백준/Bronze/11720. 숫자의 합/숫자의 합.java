import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int result = 0;
        
        for(int i = 0; i < cNum.length; i++) {
            result += cNum[i] - '0';
        }
        
        System.out.println(result);
    }
}