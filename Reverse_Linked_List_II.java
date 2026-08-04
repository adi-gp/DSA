/*

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

*/

class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null ;
        ListNode curr = head;
        for(int i = 1 ; i<left ; i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode beforeleft = prev;
        ListNode tail = curr ;

        ListNode next = null ;
        for(int i =0 ; i<(right-left+1); i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(beforeleft!= null){
            beforeleft.next = prev;
            tail.next = curr;
        }
        else{
            head = prev;
            tail.next = curr;
        }
        return head ;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */