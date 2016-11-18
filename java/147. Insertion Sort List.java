public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode cur = newHead;
            ListNode pre = cur;
            ListNode temp;
            while (cur != null && cur.val <= head.val) {
                pre = cur;
                cur = cur.next;
            }
            temp = head.next;
            pre.next = head;
            head.next = cur;
            head = temp;
        }
        return newHead.next;
    }
}