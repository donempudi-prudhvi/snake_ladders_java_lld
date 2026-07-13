package model;

public abstract class Item {
    
    protected int start;
    protected int end;

    Item(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    public  abstract int getFinalPosition();
    
}
