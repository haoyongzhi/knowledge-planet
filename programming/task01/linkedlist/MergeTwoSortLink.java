package net.smartleon.knowledgeplant.linkedlist;

public class MergeTwoSortLink {
    /**
     * while 将单项链表进行排序
     * 如果l1或l2为空，则返回单边。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode other = l1.val >= l2.val ? l1 : l2;
        ListNode prevHead = head;
        ListNode prevOther = other;
        while (prevHead != null) {
            ListNode next = prevHead.next;
            if (next != null && next.val > prevOther.val) {
                prevHead.next = prevOther;
                prevOther = next;
            }
            if(prevHead.next==null){
                prevHead.next=prevOther;
                break;
            }
            prevHead=prevHead.next;
        }
        return head;
    }
}
