package cracking.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {
    static List<Stack<Integer>> setOfStacks = new ArrayList<>();
    static int capacity = 10; // the capacity of each stack

    public static void push(Integer data){
        //if set is empty or the last stack is full, create a new stack
        if(setOfStacks.isEmpty() || setOfStacks.get(setOfStacks.size() - 1).size() == capacity){
            Stack<Integer> newStack = new Stack<>();
            newStack.push(data);
            setOfStacks.add(newStack);
        }else{
            setOfStacks.get(setOfStacks.size() - 1).push(data);
        }
    }

    public static Integer pop(){
        int x = setOfStacks.size() - 1;

        if(setOfStacks.isEmpty())
            return null;

        Integer ans = setOfStacks.get(x).pop();
        if(setOfStacks.get(x).isEmpty())
            setOfStacks.remove(x);
        return ans;
    }

    public static Integer popAt(int x){

        if (x < 0 || x >= setOfStacks.size()) {
            return null; //invalidate index, return null
        }

        Integer ans = setOfStacks.get(x).pop();
        if(setOfStacks.get(x).isEmpty()) setOfStacks.remove(x);
        return ans;
    }
}
