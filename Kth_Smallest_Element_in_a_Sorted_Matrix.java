/*

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2

*/

class Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int countElement(int[][] matrix, int guess){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col <m){
            if(matrix[row][col]<=guess){
                count = count + row +1;
                col++;
            }
            else{
                row --;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n-1][m-1];
        int res = -1;
        while(low<=high){
            int guess = (low + high)/2;
            int ans = countElement(matrix,guess);
            if(ans<k){
                low = guess +1;
            }
            else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }
}