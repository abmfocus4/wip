// Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
// Kadane's algo

int maxh = 0, maxf = Integer.MIN_VALUE;
		    for(int i=0; i<n; i++){
		        maxh+=arr[i];
		        maxf=Integer.max(maxh,maxf);
		        if(maxh<0)
		            maxh=0;
