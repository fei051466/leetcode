public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        int count = 0;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        pre.next = head;
        cur = head;
        count = count - k % count;
        while (--count != 0) {
            cur = cur.next;
        }

        ListNode result = cur.next;
        cur.next = null;

        return result;
    }
}