public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode last = res;
        while(current != null){
            if(current.val == val){
                last.next = current.next;
            }
            else{
                last = current;
            }
            current = current.next;
        }
        return res.next;
    }
}