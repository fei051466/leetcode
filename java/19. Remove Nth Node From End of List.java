/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        removeNthFromEndS(newHead, n);
        return newHead.next;
    }
    private int removeNthFromEndS(ListNode head, int n){
        if (head == null)
            return 0;
        else{
            int last = removeNthFromEndS(head.next, n);
            if (n == last){
                head.next = head.next.next;
            }
            return last + 1;
        }
    }
}