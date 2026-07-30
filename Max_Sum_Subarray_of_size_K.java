class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int low =0;
        int high = k-1;
        int sum =0;
        int result = 0;
        int n = arr.length;
        for(int i=low; i<=high;i++){
            sum += arr[i];
        }
        while(high<n){
            result = Math.max(result,sum);
            low++;
            high++;
            if(high==n){
                break;
            }
            else{
                sum = sum+ arr[high]-arr[low-1];
            }
        }
        return result;
    }
}