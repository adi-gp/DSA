/*

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

*/

import java.util.*;
class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        backtracking(nums , n , idx , diary , res);
        return res;
    }
    public void backtracking(int [] nums , int n , int idx ,List<Integer> diary , List<List<Integer>> res){
        if (idx == n) {
            
            res.add(new ArrayList<>(diary));
            return;
        }
        // Include
        diary.add(nums[idx]);
        backtracking(nums , n , idx+1, diary , res);

        // Exclude 
        diary.remove(diary.size()-1);
        while (idx+1 < n && nums[idx]==nums[idx+1]){
            idx++;
        }
        backtracking(nums, n , idx+1 , diary ,res);

        
    }
}

/*

Easier solution (Not Optimal):

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        backtracking(nums , n , idx , diary , res);
        return res;
    }
    public void backtracking(int [] nums , int n , int idx ,List<Integer> diary , List<List<Integer>> res){
        if (idx == n) {
            if (!res.contains(diary)) {
                res.add(new ArrayList<>(diary));
            }
            return;
        }
        diary.add(nums[idx]);
        idx++;
        backtracking(nums , n , idx , diary , res);

        diary.remove(diary.size()-1);
        backtracking(nums, n , idx , diary ,res);
    }
}

*/