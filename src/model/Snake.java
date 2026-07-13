package model;

public class Snake extends Item{
    
    public Snake(int start, int end){
        super(start, end);
        if(start<=end){
            throw new IllegalArgumentException(" Start cannot be less than or equal to end");
        }

    }
    
     @Override
    public int getFinalPosition(){
        return this.end;
    }
}