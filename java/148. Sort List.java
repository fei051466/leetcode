class HeadAndTail {
    ListNode head;
    ListNode tail;
}

public class Solution {
    private HeadAndTail quickSortList(ListNode headNode) {
        HeadAndTail result = new HeadAndTail();
        if (headNode == null) {
            result.head = headNode;
            result.tail = headNode;
            return result;
        }

        ListNode lessHead = new ListNode(0);
        ListNode lessprev = lessHead;
        ListNode moreHead = new ListNode(0);
        ListNode moreprev = moreHead;
        ListNode compareNodeListHead = headNode;
        ListNode compareNodeListPrev = compareNodeListHead;
        HeadAndTail less;
        HeadAndTail more;
        int compareVal = headNode.val;


        headNode = headNode.next;
        while (headNode != null) {
            if (headNode.val < compareVal) {
                lessprev.next = headNode;
                lessprev = lessprev.next;
            }
            else if (headNode.val > compareVal) {
                moreprev.next = headNode;
                moreprev = moreprev.next;
            }
            else {
                compareNodeListPrev.next = headNode;
                compareNodeListPrev = compareNodeListPrev.next;
            }
            headNode = headNode.next;
        }
        lessprev.next = null;
        moreprev.next = null;

        less = quickSortList(lessHead.next);
        more = quickSortList(moreHead.next);

        if (less.tail != null) {
            less.tail.next = compareNodeListHead;
            result.head = less.head;
        }
        else {
            result.head = compareNodeListHead;
        }
        compareNodeListPrev.next = more.head;
        if (more.tail != null) {
            result.tail = more.tail;
        }
        else {
            result.tail = compareNodeListPrev;
        }

        return result;
    }

    public ListNode sortList(ListNode head) {
        return quickSortList(head).head;
    }
}