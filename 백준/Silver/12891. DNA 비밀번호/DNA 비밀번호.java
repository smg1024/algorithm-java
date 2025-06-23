import java.util.*;
import java.io.*;

public class Main {
    
    static int[] myPassword;
    static int[] rules;
    static int ruleCheck;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // DNA string info
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] DNA = new char[S];
        DNA = br.readLine().toCharArray();
        
        // password rule info - ACGT
        rules = new int[4];
        ruleCheck = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            rules[i] = Integer.parseInt(st.nextToken());
            if(rules[i] == 0) {
                ruleCheck++;
            }
        }
        
        // initialize
        myPassword = new int[4];
        int count = 0;
        int left = 0;
        int right = P - 1;
        
        for(int i = 0; i < P; i++) {
            addRight(DNA[i]);
        }
        
        if(ruleCheck == 4) count++;
        
        // implementation
        for(int i = P; i < S; i++) {
            int j = i - P;    // left index
            addRight(DNA[i]);
            removeLeft(DNA[j]);
            if(ruleCheck == 4) count++;
        }
        
        System.out.println(count);
        br.close();
    }
    
    private static void addRight(char c) {
        switch(c) {
            case 'A':
                myPassword[0]++;
                if(myPassword[0] == rules[0]) ruleCheck++;
                break;
            case 'C':
                myPassword[1]++;
                if(myPassword[1] == rules[1]) ruleCheck++;
                break;
            case 'G':
                myPassword[2]++;
                if(myPassword[2] == rules[2]) ruleCheck++;
                break;
            case 'T':
                myPassword[3]++;
                if(myPassword[3] == rules[3]) ruleCheck++;
                break;
        }
    }
    
    private static void removeLeft(char c) {
        switch(c) {
            case 'A':
                if(myPassword[0] == rules[0]) ruleCheck--;
                myPassword[0]--;
                break;
            case 'C':
                if(myPassword[1] == rules[1]) ruleCheck--;
                myPassword[1]--;
                break;
            case 'G':
                if(myPassword[2] == rules[2]) ruleCheck--;
                myPassword[2]--;
                break;
            case 'T':
                if(myPassword[3] == rules[3]) ruleCheck--;
                myPassword[3]--;
                break;
        }
    }
}