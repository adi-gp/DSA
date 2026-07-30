/*.   PROBLEM STATEMENT:    

Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces. */



import java.util.*;
class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int low = 0;
        int result = 0;
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int high = 0 ; high<n; high ++){
            char c = s.charAt(high);
            map.put(c,map.getOrDefault(c,0)+1);

            if(map.size()==(high-low+1)){
                result = Math.max(result,high-low+1);
            }
            else{
                while(map.size()<(high-low+1)){
                    char left = s.charAt(low);
                    map.put(left , map.get(left)-1);
                    if(map.get(left)==0){
                        map.remove(left);
                    }
                    low++;
                }
                
            }
        }
        return result;
        
    }
}


