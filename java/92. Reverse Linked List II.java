public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        int index = 1;
        while (index != m) {
            pre = pre.next;
            index++;
        }
        ListNode last = null;
        ListNode cur = pre.next;
        while (index <= n) {
            ListNode temp = cur.next;
            cur.next = last;
            last = cur;
            cur = temp;
            index++;
        }
        pre.next.next = cur;
        pre.next = last;
        return res.next;
    }
}