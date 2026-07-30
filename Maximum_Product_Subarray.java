/*

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

*/


class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int best_product = nums[0];
        int worst_product =nums[0];
        int ans = nums[0];
        for(int i =1 ; i<n ; i++){
            int v1 = nums[i];
            int v2 = nums[i]* best_product;
            int v3 = nums[i]* worst_product;
            best_product = Math.max(v1,Math.max(v2,v3));
            worst_product = Math.min(v1,Math.min(v2,v3));
            ans = Math.max(best_product, ans);
        }
        return ans;
        
    }
}