public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode temp = headA;
        while(temp != null){
            lengthA += 1;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            lengthB += 1;
            temp = temp.next;
        }
        int difference = 0;
        ListNode headC;
        ListNode headD;
        if(lengthA > lengthB){
            headC = headA;
            headD = headB;
            difference = lengthA - lengthB;
        }
        else{
            headC = headB;
            headD = headA;
            difference = lengthB - lengthA;
        }
        while(difference--!=0){
            headC = headC.next;
        }
        while(headC!=headD){
            headC = headC.next;
            headD = headD.next;
        }
        return headC;
    }
}