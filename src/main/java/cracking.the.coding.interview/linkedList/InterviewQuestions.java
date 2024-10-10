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

        LinkedNode kthToLast = kthToLast(head, 2);
        head.print();
        System.out.println(kthToLast.data);

        deleteMiddleNode(head, 2);
        head.print();

    }

    /**
     * question: remove duplicates from a unsorted linked list
     * no temporary buffer
     * solution: nested loop to compare each node with every other node, removing duplicates
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

    /**
     * question: reverse a linked list
     * recursion solution
     */
    public static LinkedNode reverseLinkedList(LinkedNode head){
        if(head == null || head.next == null)
            return head;

        LinkedNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * question: check if a stack is palindrome
     * solution: use stack to store half of the linked list
    **/
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

    /**
     * question: check if a stack is palindrome
     * solution: on itself, reverse the second half and check
     **/
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
        middle.next = newHead;

        while(newHead != null){
            if(newHead.data!=orgHead.data) return false;

            newHead = newHead.next;
            orgHead = orgHead.next;
        }

        middle.next = reverseLinkedList(middle.next);

        return true;
    }


    /**
     * * question: return kth to last
     * solution: two pointers
     *
     * @param head head node of the lined list
     * @param k kth to last
     * @return the kth node to last
     */
    public static LinkedNode kthToLast(LinkedNode head, int k){
        if (head == null) return null;

        LinkedNode a = head;
        LinkedNode b = head;
        int i = 0;

        while(a != null && i < k){
            a = a.next;
            i++;
        }

        while(a!=null){
            a = a.next;
            b = b.next;
        }

        return b;
    }

    /**
     *
     * @param head the head node of the linked list
     * @param m the middle node needed to be deleted
     */
    public static void deleteMiddleNode(LinkedNode head, int m){
        if(head == null) return;
        LinkedNode a = head;
        LinkedNode b = head.next;
        while(b.next != null){
            if(b.data == m){
                a.next = b.next;
            }
            a = a.next;
            b = a.next;
        }
    }



}
