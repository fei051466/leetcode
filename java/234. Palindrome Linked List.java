public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        while(slow != null){
            if(head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;

    }
    private ListNode reverse(ListNode slow){
        ListNode last = null;
        ListNode temp;
        while(slow != null){
            temp = slow.next;
            slow.next = last;
            last = slow;
            slow = temp;
        }
        return last;

    }

}