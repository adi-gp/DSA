/*

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        if (n == 0) {
            return new int[]{-1, -1};
        }

        int[] res = {-1, -1};

        
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            }
            else if (nums[guess] > target) {
                high = guess - 1;
            }
            else {
                res[0] = guess;
                high = guess - 1;
            }
        }

        
        low = 0;
        high = n - 1;

        
        while (low <= high) {
            int guess = (low + high) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            }
            else if (nums[guess] > target) {
                high = guess - 1;
            }
            else {
                res[1] = guess;
                low = guess + 1;
            }
        }

        return res;
    }
}