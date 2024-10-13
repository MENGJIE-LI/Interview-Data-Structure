package cracking.the.coding.interview.stacksAndQueues;

import java.util.Stack;

public class getMinStack {

    static Stack<Integer> dataStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();


    public static void push(int data){
        dataStack.push(data);
        if(minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
        else{
            minStack.push(minStack.peek());
        }
    }

    public static Integer pop(){
        if(dataStack.isEmpty())
            return null;
        minStack.pop();
        return dataStack.pop();
    }

    public static Integer getMin(){
        if(minStack.isEmpty()) return null;
        return minStack.peek();
    }
}
