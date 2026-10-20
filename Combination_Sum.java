/*

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

*/
import java.util.*;
class Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int idx = 0;
        int sum = 0;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        backtracking(candidates, target, n, idx, res, diary, sum);

        return res;
    }

    public void backtracking(int[] candidates, int target, int n, int idx,
                             List<List<Integer>> res, List<Integer> diary, int sum) {

        if (sum == target) {
            res.add(new ArrayList<>(diary));
            return;
        }

        if (sum > target) {
            return;
        }

        if (idx == n) {
            return;
        }

        // Pick
        diary.add(candidates[idx]);
        sum = sum + candidates[idx];

        backtracking(candidates, target, n, idx, res, diary, sum);

        // Undo the choice
        diary.remove(diary.size() - 1);
        sum = sum - candidates[idx];

        // Skip
        backtracking(candidates, target, n, idx + 1, res, diary, sum);
    }
}