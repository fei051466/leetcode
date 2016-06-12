public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
        {
            ListNode nexttemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexttemp;
        }
        return prev;
    }
}