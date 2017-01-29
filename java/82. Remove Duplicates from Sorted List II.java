public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        ListNode cur = head;
        int deleted = 0;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                deleted = 1;
            }
            else {
                if (deleted == 0) {
                    pre.next = cur;
                    pre = cur;
                }
                cur = cur.next;
                pre.next = null;
                deleted = 0;
            }
        }

        return result.next;
    }
}