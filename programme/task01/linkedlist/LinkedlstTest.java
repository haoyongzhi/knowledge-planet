package net.smartleon.knowledgeplant.linkedlist;

public class LinkedlstTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Linkedlst lst = new Linkedlst();
        Node head = new Node(11,null);
        lst.addHead(head);
        lst.addTail(new Node(22));
        lst.addTail(new Node(33));
        System.out.println("打印链表：");
        lst.printList();
        System.out.println();
        System.out.println("删除首端节点：");
        lst.delHead();
        lst.printList();
        System.out.println();
        System.out.println("删除首端节点：");
        lst.delHead();
        lst.printList();
    }
}
