public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode result = new ListNode(-1);
        ListNode preLast = result;
        ListNode curHead = head;
        int index = 0;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
            if (index == k) {
                preLast.next = pre;
                preLast = curHead;
                curHead = cur;
                index = 0;
                pre = null;
            }
        }
        if (index != k) {
            cur = pre;
            pre = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            preLast.next = pre;
        }

        return result.next;
    }
}