package cracking.stacksAndQueues;

import java.util.Stack;

public class QueueViaStack {
    Stack<Integer> stackNew = new Stack<>();
    Stack<Integer> stackOld = new Stack<>();

    public void add(Integer data){
        stackNew.add(data);
    }

    public Integer peek(){
        shiftStack();
        return stackOld.peek();
    }

    public Integer remove(){
        shiftStack();
        return stackOld.pop();
    }

    public void shiftStack(){
        if(stackOld.isEmpty()){
            while(!stackNew.isEmpty()){
                stackOld.push(stackNew.pop());
            }
        }
    }
}
