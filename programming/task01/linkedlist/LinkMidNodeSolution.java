package net.smartleon.knowledgeplant.linkedlist;

public class LinkMidNodeSolution {
    public LinkMidNode middleNode(LinkMidNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        LinkMidNode slow=head;
        LinkMidNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
