package cracking.doubleLinkedList;

public class InterviewQuestions {

    public static void main(String[] args){

    }

    public static DoubleLinkedNode reverseLinkedList(DoubleLinkedNode head){
        if(head == null || head.next == null){
            head.last = null;
            return head;
        }

        DoubleLinkedNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.last = head.next;
        head.next = null;

        return newHead;
    }

}
