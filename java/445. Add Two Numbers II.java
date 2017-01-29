/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode preNode = null;
        Stack<Integer> nodeStack1 = new Stack<Integer>();
        Stack<Integer> nodeStack2 = new Stack<Integer>();
        Stack<Integer> resultStack = new Stack<Integer>();

        int cur = 0;
        int plus = 0;
        int one, two;

        while (l1 != null){
            nodeStack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            nodeStack2.add(l2.val);
            l2 = l2.next;
        }

        while (!nodeStack1.empty() || !nodeStack2.empty()){
            if (!nodeStack1.empty())
                one = nodeStack1.pop();
            else
                one = 0;
            if (!nodeStack2.empty())
                two = nodeStack2.pop();
            else
                two = 0;
            cur = one + two + plus;
            if (cur > 9){
                cur = cur % 10;
                plus = 1;
            }
            else
            {
                plus = 0;
            }
            resultStack.add(cur);
        }
        if (plus != 0)
            resultStack.add(1);

        while (!resultStack.empty()){
            ListNode curNode = new ListNode(resultStack.pop());
            if (result == null){
                result = curNode;
            }
            else{
                preNode.next = curNode;
            }
            preNode = curNode;
        }

        return result;
    }
}