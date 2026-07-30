/*

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false. 

*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Linked_List_Cycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        // Link nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Create cycle
        n4.next = n2;

        System.out.println(hasCycle(n1)); // true
    }
}