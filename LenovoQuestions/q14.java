
import java.util.*;


//consecutive swaps
public class q14{
    static int[] pos, arr;

    static void swap(int i,int j){
		//swap ith and jth position
		pos[arr[i]] = j;
        pos[arr[j]] = i;
        
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

    public static void minBribes(int[] q, int n){
        pos = new int[n];
        arr = new int[n];

        //arr contains original pos
        //pos contains the positions after the swaps

        for(int i = 0; i < n; i++)
            arr[i] = pos[i] = i;
            
        int swaps = 0;
        boolean flag = true;

        for(int i = 0; i < n; i++){ //swaps greater than 2 break
            if(pos[q[i]] - i > 2){
                flag = false;
                break;
            } //remove this if you just wanna calculate the number of swaps
            while(pos[q[i]] > i){ //if element not in its original position
                swap(pos[q[i]], pos[q[i]] - 1);
                swaps++;
            }
        }
        System.out.println(flag ? swaps : "Too chaotic");
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++)
        {
            int n = sc.nextInt();
            String q_items[] = sc.nextLine().split(" ");

            int q[] = new int[n];

            for(int j = 0; j<n; j++){
                int q_item = Integer.parseInt(q_items[i]);
                q[i] = q_item;
            }
            minBribes(q, n); 
        }

    }
}