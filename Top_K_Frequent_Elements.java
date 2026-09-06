/*


Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/
import java.util.*;
class Top_K_Frequent_Elements {
    class Pair {
        int freq ;
        int num ;
        Pair(int f , int n){
            freq = f ;
            num = n ;
        }
    }
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        PriorityQueue <Pair> heap = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq != b.freq){
                    return a.freq - b.freq;
                }
                else{
                    return a.num - b.num;
                }
            }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int num = entry.getKey();

            int freq = entry.getValue();

            if (heap.size() < k) {

                heap.add(new Pair(freq, num));

            }

            else if (freq > heap.peek().freq) {

                heap.poll();

                heap.add(new Pair(freq, num));

            }

        }

        int[] res = new int[k];

        int i = 0;

        while (!heap.isEmpty()) {

            res[i] = heap.poll().num;

            i++;

        }

        return res;

    }

}