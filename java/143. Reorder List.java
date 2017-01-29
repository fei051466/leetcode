public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;

        while (fast != null && fast.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        last.next = null;

        ListNode pre = null;
        ListNode cur = slow;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        cur = new ListNode(-1);

        while (head != null && pre != null) {
            cur.next = head;
            head = head.next;
            cur.next.next = pre;
            pre = pre.next;
            cur = cur.next.next;
        }
        if (head != null)
            cur.next = head;
    }
}