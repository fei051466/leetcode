public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode curSmaller = smallerHead;
        ListNode biggerHead = new ListNode(0);
        ListNode curBigger = biggerHead;
        while (head != null) {
            if (head.val < x) {
                curSmaller.next = head;
                curSmaller = curSmaller.next;
            }
            else {
                curBigger.next = head;
                curBigger = curBigger.next;
            }
            head = head.next;
        }
        curSmaller.next = biggerHead.next;
        curBigger.next = null;
        return smallerHead.next;
    }
}