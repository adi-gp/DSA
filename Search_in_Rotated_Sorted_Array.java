/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

*/

class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int res = -1;

        int low = 0;
        int high = n - 1;

        int pivot = 0;

        
        while (low <= high) {

            int guess = (low + high) / 2;

            if (nums[guess] > nums[n - 1]) {
                low = guess + 1;
            }
            else {
                pivot = guess;
                high = guess - 1;
            }
        }

        
        int low1 = 0;
        int high1 = pivot - 1;

        
        int low2 = pivot;
        int high2 = n - 1;

        
        while (low1 <= high1) {

            int guess1 = (low1 + high1) / 2;

            if (nums[guess1] > target) {
                high1 = guess1 - 1;
            }
            else if (nums[guess1] < target) {
                low1 = guess1 + 1;
            }
            else {
                res = guess1;
                return res;
            }
        }

        
        while (low2 <= high2) {

            int guess2 = (low2 + high2) / 2;

            if (nums[guess2] > target) {
                high2 = guess2 - 1;
            }
            else if (nums[guess2] < target) {
                low2 = guess2 + 1;
            }
            else {
                res = guess2;
                return res;
            }
        }

        return res;
    }
}