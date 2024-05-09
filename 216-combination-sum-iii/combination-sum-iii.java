
class Solution {
     public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> res = new ArrayList();
         backtrack(k, n, 1, res, new ArrayList()); // 1...9
         return res;
     }
     
     private void backtrack(int k, int n, int i, List<List<Integer>> res, List<Integer> temp_list) {
         if (temp_list.size() == k && n == 0) {
             res.add(new ArrayList(temp_list)); // create new arrayList
             return;
         }
         
         if (n < 0) {
             return;
         }
         
         for (int index = i; index <= 9; index++) {
            temp_list.add(index);
            backtrack(k, n - index, index + 1, res, temp_list);
            temp_list.remove(temp_list.size() - 1);
         }
         
     }
}


