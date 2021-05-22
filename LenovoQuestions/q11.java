import java.util.Scanner;

// to resolve the resource leak problem you can do sc.close() in a finally block

public class q11 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c[] = new int[n];
        for(int i = 0; i<n; i++){
            c[i] = sc.nextInt();
        }

        int jumps = -1;

        // the loop means: keeps jumping from the i-th cloud between 0 and n-1, to 
        // (1) if there are two spaces left at least and if the two cloud down happens to be an ordinary cloud, jumps two space (2) if not, just jump one space

        for(int i = 0; i < n; i++, jumps++){
            if(i < n-2 && c[i+2] == 0) i++;
        }

        System.out.println(jumps);

    }
}