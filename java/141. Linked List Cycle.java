/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null)
        {
            if (slow == fast.next)
                return true;
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return false;
            else
                fast = fast.next;
        }
        return false;
    }
}