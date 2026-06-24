class Dutch_National_Flag {
    public void swap(int[] arr, int a, int b){
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    }
    public void sortColors(int[] nums){
        int n = nums.length;
        int low=0;
        int high=n-1;
        int mid = 0;
        while(mid<=high){
            if( nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,low,mid);
                mid++;
                low++;
            }
        }
    }
}