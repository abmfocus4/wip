// https://leetcode.com/problems/find-all-anagrams-in-a-string/

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        //error checking
        if(n > m) return new ArrayList<>();
        
        //window
        int[] cnt_arr = new int[26];
        for(int i = 0; i < n; i++){
            cnt_arr[s.charAt(i) - 'a']++;
            cnt_arr[p.charAt(i) - 'a']--;
        }
        
        //checking if we found anagram
        List<Integer> list = new ArrayList<>();
        for(int i = n; i < m; i++){
            if(areAllZeroes(cnt_arr)){
                list.add(i - n); //adding first index off anagram
                // list.add(substring(i-n, i)); // adding string to list
            }
            if(i == m) break; //no need to slide the window anymore
            // slide the window
            cnt_arr[s.charAt(i) - 'a']++;   //adding first char of window_new
            cnt_arr[s.charAt(i - n) - 'a']--; //removing first char of window_old
        }

        // if(areAllZeroes(cnt_arr)){ //c
        //     list.add(m - n);
        // }
        
        return list;
    }
    
    boolean areAllZeroes(int[] cnt_arr){
        for(int i = 0; i < cnt_arr.length; i++){
            if(cnt_arr[i] != 0) return false;
        }
        return true;
    }