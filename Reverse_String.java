/*

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

*/
import java.util.*;
class Solution {
    public void reverseString(char[] s) {
        int n = s.length; 
        Stack <Character> ch = new Stack <>();
        for (int i = 0 ; i < n ; i++){
            ch.push(s[i]);
        }
        int i = 0;
        while(!ch.isEmpty()&& i<n){
            char c = ch.peek();
            s[i] = c ;
            ch.pop();
            i++;
        }
    }
}