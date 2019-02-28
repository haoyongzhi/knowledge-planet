package net.smartleon.knowledgeplant.linkedlist;

public class LinkInversionNode {
    private int Data;// 数据域
    private LinkInversionNode Next;// 指针域

    public LinkInversionNode(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public LinkInversionNode getNext() {
        return Next;
    }

    public void setNext(LinkInversionNode Next) {
        this.Next = Next;
    }
}