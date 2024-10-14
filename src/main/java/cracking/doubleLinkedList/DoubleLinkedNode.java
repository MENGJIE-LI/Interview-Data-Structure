package cracking.doubleLinkedList;

public class DoubleLinkedNode {
    DoubleLinkedNode next = null;
    DoubleLinkedNode last = null;
    int data;

    public DoubleLinkedNode(int d){data = d;}

    void appendToTail(int d){
        DoubleLinkedNode end = new DoubleLinkedNode(d);
        DoubleLinkedNode n = this;
        DoubleLinkedNode pre = this;

        while(n.next != null){
            n = n.next;
            pre = n;
        }
        n.next = end;
        n.last = pre;
    }

    void print(){
        DoubleLinkedNode temp = this;
        while (temp.next != null) {
            System.out.print(temp.data + " - > ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

}
