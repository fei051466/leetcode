/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = even;
        while(even.next != null && even.next.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        if(even.next != null){
            odd.next = even.next;
            even.next = null;
            odd.next.next = even_head;
        }
        else{
            odd.next = even_head;
        }
        return head;
    }
}