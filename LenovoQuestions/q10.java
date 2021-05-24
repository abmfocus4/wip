import java.util.*;
// https://www.hackerrank.com/challenges/counting-valleys/problem
public class q10 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        String s = sc.next();
        
        int v = 0; //number of valleys
        int lvl = 0; //current level

        for(char c : s.toCharArray()){
            if(c == 'U') lvl++;
            if(c == 'D') lvl--;

            if(c == 'U' && lvl == 0)
                v++;
        }

        System.out.println(v);

    }
}