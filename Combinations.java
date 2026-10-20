/*


Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

*/

import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List <Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int[]arr = new int[n];
        for(int i = 1 ; i<=n ;i++){
            arr[i-1]= i;
        }
        int idx = 0;

        backtracking(arr,n,k,idx,diary,res);

        return res;

    }
    public void backtracking(int [] arr , int n , int k ,int idx ,List <Integer> diary ,List<List<Integer>> res ){
        if(diary.size() == k){
            res.add(new ArrayList<>(diary));
            return;
        }
        if(idx == n){
            return;
        }
        diary.add(arr[idx]);
        backtracking(arr,n,k,idx+1,diary,res);

        diary.remove(diary.size()-1);
        backtracking(arr,n,k,idx+1,diary,res);
    }
}