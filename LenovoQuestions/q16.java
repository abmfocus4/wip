import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class q16 {
    public static void main(String[] args) throws Exception {
		new q16().run();
    }

    StreamTokenizer st;
    
    private void run() throws Exception{
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt(); //size of array
        int m = nextInt();  // number of operations

        int[] a = new int[n+1];
        for(int i = 0; i<m; i++){ //one interation

            int l = nextInt() - 1; //left index
            int r = nextInt() - 1; //right index
            int v = nextInt();  //value

            for(int j = l; j<=r; j++) //add v to all elements between l and r
                a[j] += v;
        }

        System.out.println(max(a));

    } 

    private int max(int[] a){
        int max = a[0];
        for(int element : a)
        {
            if(max < element){
                max = element;
            }
        }
        return 0;
    }

    private int nextInt() throws Exception {
		st.nextToken();
		return (int) st.nval;
	}
}