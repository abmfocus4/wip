import java.util.*;
// ArrayList<Integer> list = new ArrayList<Integer>();
// 			for(int i = n; i >= 1; i--) {
// 				list.add(i);
// 	}

public class q13 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i<n ; i++){
            a[i] = sc.nextInt();
        }

        int b[] = new int[n];
        for(int i = 0;  i<n; i++){ //left rotation
            if(i-d < 0) b[n-d+i] = a[i];
            else b[-d+i] = a[i];
        }

        for (int element : b)
            System.out.println(b[element] + " " );
    }
}