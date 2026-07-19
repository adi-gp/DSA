/*

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

*/
import java.util.*;
class Contiguous_Array {
    public int findMaxLength(int[] nums) {
        int zero = 0; 
        int one = 0;
        int result = 0 ;
        HashMap <Integer , Integer> map = new HashMap <>();
        map.put(0,-1);
        for(int i = 0; i<nums.length ; i++){
            if(nums[i]==0){
                zero += 1;
            }
            else{
                one += 1;
            }
            int diff = one - zero ;
            if(!map.containsKey (diff)){
                map.put(diff , i);
            }
            if(map.containsKey(diff)){
                result = Math.max(result , (i-map.get(diff)));
            }
        }
        return result;
    }
}