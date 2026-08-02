/*

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

*/
import java.util.*;
class Longest_Palindrome {
    public int longestPalindrome(String s) {
        HashMap <Character , Integer> map = new HashMap <>();
        for( char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int result = 0;
        for(int count : map.values()){
            if(count %2 == 0){
                result = result + count ;
            }
            else{
                result = result + count -1;
            }
        }
        return result == s.length() ? result : result +1;
    }
}



