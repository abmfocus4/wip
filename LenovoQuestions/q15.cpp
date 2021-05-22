#include <bits/stdc++.h>
using namespace std;

int swap_counter(int[] a, int n){
    pair<int, int> p[n];

    for(int i = 0; i<n; i++){
        p[i].first = a[i]; 
        p[i].second = i;
    }

    int cycle_len = 0;
    int visited[n] = {}; //init to 0

    sort(p, p+n);

    for(int i = 0; i<n; i++){
        if(visited[i] || p.second == i) //if it's in the right place
            continue;
        
        int j = i;
        int cycle_size = 0;
        
        //following the cycle
        while(!visited[j]){
            visited[j] = 1; //node is visited
            j = p[j].second;
            cycle_len++ 
        }

        total_swaps += cycle_len-1;
    }

    delete a[];
    return total_swaps;
}

int main(){
    int n;
    scanf("%d", &n);

    int[] a = new int[n];
    for (int i = 0; i<n; i++){
        scanf("%d", &a[i]);
    }

    int num_swaps = swap_counter(a, n);
    printf("%d\n", num_swaps);
    
    return 0;
}