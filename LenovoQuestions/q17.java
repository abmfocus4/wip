//two arrays a and b of different sizes
//the common elements in the array
import java.util.*;
public class q17{

    public static void commonElements(Integer[] arr1, Integer[] arr2)
    {
        HashSet<Integer> hs1 = new HashSet<Integer>(Arrays.asList(arr1));
        HashSet<Integer> hsResult = new HashSet<Integer>();

        for(int i = 0; i < arr2.length; i++){

            if(hs1.contains(arr2[i]))
                hsResult.add(arr2[i]);

        }

        Iterator<Integer> i = hsResult.iterator(); 
        while(!i.hasNext())
            System.out.println(i.next());
        
    }

    // ArrayList<int[]> data = ... // load a dataset`

    // Map<Integer[], Double> frequencies = new HashMap<Integer[], Double>();

//    // to boxed array
// Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
// Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );

// // To boxed list
// List<Integer> you  = Arrays.stream( data ).boxed().collect( Collectors.toList() );
// List<Integer> like = IntStream.of( data ).boxed().collect( Collectors.toList() );

}