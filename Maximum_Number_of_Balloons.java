
/*

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.

*/
import java.util.*;
class Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character, Integer> textMap = new HashMap <>();
        HashMap <Character , Integer> balloonMap = new HashMap<>();
        for(char c : text.toCharArray()){
            textMap.put(c,textMap.getOrDefault(c,0)+1);
        }
        String balloon = "balloon";
        for(char c : balloon.toCharArray()){
            balloonMap.put(c,balloonMap.getOrDefault(c,0)+1);
        }
        int ans = Integer.MAX_VALUE;
        for(char c : balloon.toCharArray()){
            int available = textMap.getOrDefault(c,0);
            int required = balloonMap.get(c);
            ans = Math.min(ans , available/required);
        }
        return ans;
    }
}