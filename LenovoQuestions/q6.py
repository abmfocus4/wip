# Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

for f in range(t):
    # taking multiple inputs at a time  
    # and type casting using list() function 
    l1=list(map(int,input().split())) #str to list
    l2=list(map(int,input().split()))
    x=l1+l2
    x.sort()
    l1=x[:len(l1)]
    l2=x[len(l1):]
    for i in range(len(l1)):
        print(l1[i],end=' ')

    for i in range(len(l2)):
        print(l2[i],end=' ')
    print()