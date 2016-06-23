/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode current = newHead;
        ListNode temp = null;
        while (head != null && head.next != null)
        {
            temp = head.next.next;
            current.next = head.next;
            current.next.next = head;
            head.next = temp;
            head = temp;
            current = current.next.next;
        }
        return newHead.next;
    }
}