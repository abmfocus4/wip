// Given an array of distinct integers. The task is to count all the 
// triplets such that sum of two elements equals the third element.

static void countTriplets(int a[],int size){
    Map< Integer,Integer> map = new HashMap< Integer,Integer>(); 
   for(int m = 0; m < size ; m++){
       map.put(a[m],m);
    }
   int count = 0;
   for(int i = 0; i < size-1; i++){
       for(int j = i+1; j < size; j++){
           if(map.containsKey(a[i]+a[j]))
              count++;
       }
   }
  if(count == 0) 
      System.out.println("-1");
  else 
   System.out.println(count);
}
}