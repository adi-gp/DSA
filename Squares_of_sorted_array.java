import java.util.* ;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i =0 ;
        int j = nums.length -1 ;
        int count = nums.length -1 ;
        int[] ans = new int[nums.length];
        for (int a =0 ;a<nums.length ; a++){
            nums[a]= nums[a]*nums[a];
        }
        while (i<=j){
            if(nums[i]>nums[j]){
                ans[count]=nums[i];
                i++;
                count --;
            }
            else{
                ans[count]=nums[j];
                j--;
                count --;
            }
        }
        return ans ;
    }
}