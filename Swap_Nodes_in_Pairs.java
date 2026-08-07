/*

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:



Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

*/

class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode first = head;

        while (first != null && first.next != null) {

            ListNode second = first.next;
            ListNode nextPair = second.next;

            // Swap current pair
            second.next = first;
            first.next = nextPair;

            // Connect previous pair to current swapped pair
            if (prev != null) {
                prev.next = second;
            }

            // Move pointers
            prev = first;
            first = nextPair;
        }

        return newHead;
    }
}