package cracking.stacksAndQueues.animalqueue;

public abstract class Animal{
    private int order;
    protected String name;
    public Animal(String name){
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

