/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode res = head;
        while (head.next != null)
        {
            if (head.next.val == head.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return res;
    }
}