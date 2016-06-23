/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode temp = null;
        while(l1!=null &&  l2!=null)
        {
            if (l1.val < l2.val)
            {
                temp = l1.next;
                current.next = l1;
                current = current.next;
                l1 = temp;
            }
            else
            {
                temp = l2.next;
                current.next = l2;
                current = current.next;
                l2 = temp;
            }
            
        }
        if (l1 == null)
            current.next = l2;
        else
            current.next = l1;
        return head.next;
    }
}