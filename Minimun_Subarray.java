/*

Given an array arr[], find the sub-array containing at least one number which has the minimum sum and return its sum.

Examples :

Input: arr[] = {3,-4, 2,-3,-1, 7,-5}
Output: -6
Explanation: The subarray is {-4,2,-3,-1} = -6


Input: arr[] = {2, 6, 8, 1, 4}
Output: 1
Explanation: The sub-array is {1} = 1


Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107

*/


class Minimum_Subarray {
    static int smallestSumSubarray(int a[], int size) {
        int worst_ending = a[0];
        int ans = a[0];
        for(int i =1 ; i<size; i++){
            int v1 = worst_ending+a[i];
            int v2 = a[i];
            worst_ending = Math.min(v1,v2);
            ans = Math.min(worst_ending , ans);
            
        }
        return ans ;
    }
}