public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode result = new RandomListNode(-1);
        RandomListNode pre = result;
        RandomListNode cur = head;

        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            pre.next = tmp;
            pre = pre.next;
            cur = cur.next;
        }

        cur = head;
        RandomListNode reCur = result.next;
        RandomListNode start;
        RandomListNode reStart;
        while (cur != null) {
            RandomListNode target = cur.random;
            start = head;
            reStart = result.next;
            if (target != null) {
                while (start != target) {
                    start = start.next;
                    reStart = reStart.next;
                }
                reCur.random = reStart;
            }
            cur = cur.next;
            reCur = reCur.next;
        }

        return result.next;
    }
}