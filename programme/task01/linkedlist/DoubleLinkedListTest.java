package net.smartleon.knowledgeplant.linkedlist;

public class DoubleLinkedListTest {
    /**
     * 获取给定head所指向链表的长度
     * @param head
     */
    public static void getAllNodes(NodeType head){
        NodeType current = head.rlink;
        while(current != head){
            System.out.println("前一个节点是: " + current.llink .data + "   当前节点是:"+ current.data + "  后一个节点是:"
                    +current.rlink.data);
            current = current.rlink;
        }
    }


    /**
     *
     * @param head
     * @param newNode 需要插入的新节点
     */
    public static void insert(NodeType head,NodeType newNode){
        NodeType current = head.rlink;
        NodeType prev = null;
        while(current != head && current.data < newNode.data){
            prev = current;
            current = current.rlink;
        }

        prev.rlink = newNode;
        newNode.llink = prev;
        newNode.rlink = current;
        current.llink = newNode;
    }

    /**
     *
     * @param head
     * @param removed 需要被移除的节点
     */
    public static void removing(NodeType head,NodeType removed){
        NodeType current = head.rlink;
        NodeType prev = null;

        while(current != head && removed.data != current.data){
            prev = current;
            current = current.rlink;
        }
        prev.rlink = current.rlink;
        current.rlink.llink = prev;
    }

    /**
     * 插入新节点后，将新节点后面的节删除
     *
     * @param head
     * @param newNode
     */
    public static void insertAndremoving(NodeType head,NodeType newNode){
        NodeType current = head.rlink;
        NodeType prev = null;
        while(current != head && current.data < newNode.data){
            prev = current;
            current = current.rlink;
        }

        prev.rlink = newNode;
        newNode.llink = prev;

        newNode.rlink = current.rlink;
        current.rlink.llink = newNode;
        current = null;


    }
    /**
     * 测试上面所写方法
     * @param args
     */
    public static void main(String[] args) {
        NodeType head = new NodeType();
        NodeType a = new NodeType(55);
        NodeType b = new NodeType(64);
        NodeType c = new NodeType(78);
        NodeType d = new NodeType(85);
        NodeType e = new NodeType(98);
        NodeType f = new NodeType(112);

        head.llink = f;
        head.rlink = a;


        a.llink = head;
        a.rlink = b;

        b.llink = a;
        b.rlink = c;

        c.llink = b;
        c.rlink = d;

        d.llink = c;
        d.rlink = e;

        e.llink = d;
        e.rlink = f;

        f.llink = e;
        f.rlink = head;
        //	insert(head,new NodeType(84));
        insertAndremoving(head,new NodeType(84));
        getAllNodes(head);
    }
}
