package cracking.the.coding.interview.stacksAndQueues;

import java.util.Stack;

public class SortStack{

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(8);
        stack.push(4);
        stack.push(6);
        stack.push(10);
        stack.push(2);

        sort(stack);
        System.out.println(stack.toString());
    }

    public static void sort(Stack<Integer> stack){
        Stack<Integer> stackHelper = new Stack<>();

        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!stackHelper.isEmpty() && temp < stackHelper.peek()){
                stack.push(stackHelper.pop());
            }
            stackHelper.push(temp);
        }

        while(!stackHelper.isEmpty()){
            stack.push(stackHelper.pop());
        }
    }

}
