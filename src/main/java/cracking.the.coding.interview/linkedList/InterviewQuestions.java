package cracking.the.coding.interview.linkedList;

import java.util.Stack;

public class InterviewQuestions {

    public static void main(String[] args){
        LinkedNode head = new LinkedNode(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(5);
        head.appendToTail(2);
        head.appendToTail(5);
        head.appendToTail(5);
        head.print();
        head = removeDuplicates(head);
        head.print();
        head = reverseLinkedList(head);
        head.print();
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        boolean isPal1 = isPalindromeUseStack(head);
        System.out.println(isPal1);
        boolean isPal2 = isPalindromeOnItself(head);
        System.out.println(isPal2);
    }

    /**
    remove duplicates from a unsorted linked list
    no temporary buffer
    nested loop to compare each node with every other node, removing duplicates
    **/
    public static LinkedNode removeDuplicates(LinkedNode head){
        LinkedNode ans = head;

        while(head!=null && head.next!=null){
            LinkedNode temp = head;
            while(temp.next!=null){
                if(temp.next.data == head.data){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
            head = head.next;
        }
        return ans;
    }

    //reverse a linked list
    public static LinkedNode reverseLinkedList(LinkedNode head){
        if(head == null || head.next == null)
            return head;

        LinkedNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //use stack to store half of the linked list
    public static boolean isPalindromeUseStack(LinkedNode head){
        LinkedNode slow = head;
        LinkedNode fast = head;
        Stack<Integer> st = new Stack<>();

        //create the stack based on the first half of the stack
        while(fast != null && fast.next != null){
            //move value into stack
            st.push(slow.data);
            //move the slow & fast pointer
            fast = fast.next.next;
            slow = slow.next;
        }

        //if the size of the linked list is odd, skip the middle one
        if(fast != null)
            slow = slow.next;

        //compare the second half of the linked list and the stack
        while(slow.next != null) {
            if (slow.data != st.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindromeOnItself(LinkedNode head){
        LinkedNode orgHead = head;

        //find the middle one
        LinkedNode slow = head;
        LinkedNode fast = head;

        while(fast.next != null && fast.next.next != null){
            //move the slow & fast pointer
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkedNode middle = slow;

        LinkedNode newHead = reverseLinkedList(slow.next);

        while(newHead != null){
            if(newHead.data!=head.data) return false;

            newHead = newHead.next;
            head = head.next;
        }

        middle.next = reverseLinkedList(middle.next);

        return true;
    }

}
