/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/


import java.util.*;
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean [] used = new boolean [n];

        backtracking(nums , n , used , diary , res);

        return res; 
    }
    public void backtracking (int [] nums , int n  , boolean [] used, List<Integer> diary ,List<List<Integer>> res){
        if(diary.size() == n){
            res.add(new ArrayList<>(diary));
            return;
        }
        for(int j =0 ; j<n ; j++){
            if(used[j]== false){
                diary.add(nums[j]);
                used[j]= true; 

                backtracking(nums , n , used , diary , res);

                diary.remove(diary.size()-1);
                used[j] = false;
            }    
        }
    }
}