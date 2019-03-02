package net.smartleon.knowledgeplant.linkedlist;

public class LinkInversion {
    public static void main(String[] args) {
        LinkInversionNode head = new LinkInversionNode(0);
        LinkInversionNode node1 = new LinkInversionNode(1);
        LinkInversionNode node2 = new LinkInversionNode(2);
        LinkInversionNode node3 = new LinkInversionNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        LinkInversionNode h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        head = Reverse1(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static LinkInversionNode Reverse1(LinkInversionNode head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        LinkInversionNode reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }
}
