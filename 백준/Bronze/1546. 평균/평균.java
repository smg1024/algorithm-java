import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // number of scores
        int num = sc.nextInt();
        // max score
        int max = 0;
        // score sum
        int sum = 0;
        // score array
        int scoreArray[] = new int[num];
        for(int i = 0; i < num; i++) {
            int score = sc.nextInt();
            scoreArray[i] = score;
            if(score > max) max = score;
            sum += score;
        }
        
        System.out.println(sum * 100.0 / max / num);
    }
}