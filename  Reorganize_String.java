/*

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

*/

import java.util.*;
class Solution {
    class Pair{
        int freq ;
        char character ;
        Pair(int f , char c ) {
            freq = f;
            character = c ;
        }
    }
    public String reorganizeString(String s) {
        HashMap <Character , Integer> map = new HashMap <>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue <Pair> heap = new PriorityQueue <>(
            (a,b) ->{
                if(a.freq != b.freq){
                    return b.freq - a.freq;
                }
                else{
                    return b.character - a.character;
                }
            }
        );
        for(Map.Entry<Character , Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            char character = entry.getKey();
            heap.add(new Pair(freq , character));
        }
        StringBuilder res = new StringBuilder();
        while(!heap.isEmpty()){
            if(res.length()==0 || res.charAt(res.length()-1)!= heap.peek().character){
                Pair p = heap.poll();
                res.append(p.character);
                p.freq -- ;
                if(p.freq != 0){
                    heap.add(p);
                }
            }
            else {
                Pair k = heap.poll();
                if(heap.isEmpty()){
                    return "";
                }
                Pair p = heap.poll();
                res.append(p.character);
                p.freq--;
                if(p.freq != 0){
                    heap.add(p);
                }
                heap.add (k);
            }
        }
        return res.toString();
    }
}