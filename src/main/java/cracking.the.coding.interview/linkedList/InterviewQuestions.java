package cracking.the.coding.interview.linkedList;

import java.util.Stack;

public class InterviewQuestions {

    public static void main(String[] args){
        LinkedNode head = new LinkedNode(1);
        head.appendToTail(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);
        head.appendToTail(1);
        head.print();

//        head = removeDuplicates(head);
//        head.print();
//
//        head = reverseLinkedList(head);
//        head.print();
//
//        head.appendToTail(2);
//        head.appendToTail(3);
//        head.appendToTail(4);
//        head.appendToTail(5);
//
//        boolean isPal1 = isPalindromeUseStack(head);
//        System.out.println(isPal1);
//
//        boolean isPal2 = isPalindromeOnItself(head);
//        System.out.println(isPal2);
//
//        LinkedNode kthToLast = kthToLast(head, 2);
//        head.print();
//        System.out.println(kthToLast.data);
//
//        deleteMiddleNode(head, 2);
//        head.print();

        LinkedNode partitionHead = partition(head, 5);
        partitionHead.print();

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
     * Question: check if a stack is palindrome
     * Solution: on itself, reverse the second half and check
     *
     * @param head the head node of the linked list
     * @return return true or false
     */
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
     * Question: return kth to last
     * Solution: two pointers
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
     * Delete nodes in the middle of the linked list
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

    /**
     * Partition a linked list
     * Solution: record 4 pointers: head and tail of the two list
     *  - the smaller part
     *  - the greater part
     *  These two parts are then combined to form the final partitioned list.
     *
     * @param head the head of the list
     * @param x the partition element
     * @return the head of the result linked list
     */
    public static LinkedNode partition(LinkedNode head, int x){
        if(head == null) return null;

        LinkedNode curr = head;
        LinkedNode smallHead = null, smallTail = null, bigHead = null, bigTail = null;

        while(curr != null ){
            LinkedNode nextNode = curr.next; // save next node
            curr.next = null; // break the link

            if(curr.data < x){
                if(smallHead == null){
                    smallHead = curr;
                    smallTail = smallHead;
                }else{
                    smallTail.next = curr;
                    smallTail = smallTail.next;
                }
            }else{
                if(bigHead == null){
                    bigHead = curr;
                    bigTail = bigHead;
                }else{
                    bigTail.next = curr;
                    bigTail = curr;
                }
            }
            curr = nextNode; // Move to the next node
        }

        if(smallHead != null) {
            smallTail.next = bigHead;
            return smallHead;
        }else{
            return bigHead;
        }
    }




}
