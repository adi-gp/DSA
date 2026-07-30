/*

Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Return the minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.

Examples:

Input: start[] = [1, 10, 7], end[] = [4, 15, 10]
Output: 1
Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings in a single room.
Input: start[] = [2, 9, 6], end[] = [4, 12, 10]
Output: 2
Explanation: 1st and 2nd meetings at one room but for 3rd meeting one another room required.
Constraints:
1 ≤ start.size() = end.size() ≤ 105
0 ≤ start[i] < end[i] ≤ 106

*/
import java.util.*;
class Meeting_Rooms_II {
    public int minMeetingRooms(int[] start, int[] end) {
        Arrays.sort(start);
        Arrays.sort(end);
        int n1 = start.length;
        int n2 = end.length;
        int i =0 ;
        int j =0;
        int count = 0;
        int result = 0;
        while(i<n1 && j <n2){
            if(start[i]<end[j]){
                count ++;
                result = Math.max(result , count);
                i++;
            }
            else if (start[i]==end[j]){
                j++;
                count -- ;
                result = Math.max(result , count);
            }
            else{
                count -- ;
                result = Math.max(result , count);
                j++;
                
            }
        }
        return result;
        
    }
}
