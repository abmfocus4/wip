// Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, then print the triplet and return true. Else return false.

bool find3Numbers(int A[], int arr_size, int sum) 
{ 
    // Fix the first element as A[i] 
    for (int i = 0; i < arr_size - 2; i++) { 
  
        // Find pair in subarray A[i+1..n-1] 
        // with sum equal to sum - A[i] 
        unordered_set<int> s; 
        int curr_sum = sum - A[i]; 
        for (int j = i + 1; j < arr_size; j++) { 
            if (s.find(curr_sum - A[j]) != s.end()) { 
                printf("Triplet is %d, %d, %d", A[i], 
                       A[j], curr_sum - A[j]); 
                return true; 
            } 
            s.insert(A[j]); 
        } 
    } 
  
    // If we reach here, then no triplet was found 
    return false; 
} 