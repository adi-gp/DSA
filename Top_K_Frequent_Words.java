/*

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?

*/
import java.util.*;
class Top_K_Frequent_Words {
    class Pair {
        int count;
        String words;

        Pair(int c, String w) {
            count = c;
            words = w;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> {
                if (a.count != b.count) {
                    return a.count - b.count;
                }
                else {
                    return b.words.compareTo(a.words);
                }
            }
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String word = entry.getKey();
            int count = entry.getValue();

            if (heap.size() < k) {
                heap.add(new Pair(count, word));
            }
            else if (count > heap.peek().count ||
                     (count == heap.peek().count &&
                      word.compareTo(heap.peek().words) < 0)) {

                heap.poll();
                heap.add(new Pair(count, word));
            }
        }

        List<String> ans = new ArrayList<>();

        while (!heap.isEmpty()) {
            ans.add(heap.poll().words);
        }

        Collections.reverse(ans);

        return ans;
    }
}