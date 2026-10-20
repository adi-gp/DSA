
/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

*/

import java.util.*;
class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        int sum = 0;

        backtracking(candidates,n,idx, target, sum ,diary,res );

        return res;
    }
    public void backtracking(int [] candidates , int n , int idx , int target, int sum,List<Integer> diary ,List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(diary));
            return;
        }
        if(sum > target){
            return;
        }
        if(idx==n){
            return;
        }
        
        diary.add(candidates[idx]);
        sum = sum + candidates[idx];

        backtracking(candidates, n , idx +1, target, sum , diary , res);

        diary.remove(diary.size()-1);
        sum = sum - candidates[idx];

        while(idx+1 <n && candidates[idx]== candidates[idx+1]){
            idx ++;
        }

        backtracking(candidates , n , idx+1 , target , sum , diary ,res);
    }
}