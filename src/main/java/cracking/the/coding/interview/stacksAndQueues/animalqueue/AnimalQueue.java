package cracking.the.coding.interview.stacksAndQueues.animalqueue;

import java.security.PublicKey;
import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;

        if(a instanceof Dog) dogs.addLast((Dog)a);
        else cats.addLast((Cat)a);
    }

    public Animal dequeueAny(){
        if(cats.isEmpty()) return dequeueDogs();
        else if(dogs.isEmpty()) return dequeueCats();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)) return dequeueDogs();
        else return dequeueCats();
    }

    public Cat dequeueCats(){
        return cats.poll();
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }

}
