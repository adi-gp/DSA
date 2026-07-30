/*

You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
 

Example 1:

Input: nums = [1,-3,2,3,-4]
Output: 5
Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
Example 2:

Input: nums = [2,-5,1,-4,3,-2]
Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

*/

class Maximum_Absolute_Sum_of_Any_Subarray {
    public int maxAbsoluteSum(int[] nums) {
        
        int bestsum = nums[0];
        int worstsum = nums[0];
        int result = nums[0];
        for(int i =1; i<nums.length ; i++){
            int v1 = bestsum +nums[i];
            int v2 = worstsum + nums[i];
            int v3 = nums[i];
            bestsum = Math.max(v1,v3);
            worstsum = Math.min(v2,v3);
            result = Math.max(result , Math.max(bestsum , Math.abs(worstsum)));
        }
        return Math.abs(result);
    }
}