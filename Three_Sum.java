import java.util.*;
class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0 ; i<n-2; i++){
            int left = i+1;
            int right = n-1 ;
            if (i>0 && nums[i]== nums[i-1]){
                continue;
            }
            else{
                while(left<right){
                    if(nums[left]+nums[right]> -nums[i]){
                        right--;
                    }
                    else if(nums[left]+ nums[right]< -nums[i]){
                        left++ ;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right -- ;
                        while(left<right && nums[left]== nums[left-1]){
                            left ++;
                        }
                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return result;
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

        }

        Three_Sum sol = new Three_Sum();

        List<List<Integer>> result = sol.threeSum(arr);

        System.out.println(result);

        sc.close();
}
}