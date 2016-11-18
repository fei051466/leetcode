public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode preSlow = null;
        while (fast.next != null && fast.next.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        if (preSlow != null) {
            preSlow.next = null;
            mid.left = sortedListToBST(head);
        }
        mid.right = sortedListToBST(slow.next);
        return mid;

    }
}