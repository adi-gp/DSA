/*

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

*/

import java.util.*;
class Task_Scheduler {
    class Pair {
        int freq ; 
        char task ;
        Pair(int freq , char task){
            this.freq = freq;
            this.task = task;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a,b) -> {
                if(a.freq!=b.freq){
                    return b.freq - a.freq;
                }
                else{
                    return a.task - b.task;
                }
            }
        );
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            char task = entry.getKey();
            heap.add(new Pair(freq , task));
        }
        int seat = 0 ;
        while(!heap.isEmpty()){
            int available_slot = n+1;
            int filled_slot = 0;
            ArrayList <Pair>  store =new ArrayList<>();
            while(filled_slot < available_slot && !heap.isEmpty()){
                Pair p = heap.poll();
                p.freq--;

                if(p.freq > 0){
                    store.add(p);
                }

                filled_slot ++;
                seat ++;
            }
            if(heap.isEmpty()&& !store.isEmpty()){
                int idle_slot = available_slot - filled_slot;
                seat += idle_slot;
            }
            for(Pair p : store){
                heap.add(p);
            }

        }
        return seat;
    }
}