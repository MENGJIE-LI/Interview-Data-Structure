package cracking.linkedList;

public class LinkedNode {
    LinkedNode next = null;
    int data;

    public LinkedNode(int d) {
        data = d;
    }

    void appendToTail(int d){
        LinkedNode end = new LinkedNode(d);
        LinkedNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void print(){
        LinkedNode temp = this;
        while (temp.next != null) {
            System.out.print(temp.data + " - > ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
