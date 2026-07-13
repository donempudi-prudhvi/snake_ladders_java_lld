package model;

public class Ladder extends Item{
    
    public Ladder(int start, int end){
        super(start, end);
        
        if(start>=end){
            throw new IllegalArgumentException(" Start cannot be greated than end");
        }

    }
    @Override
    public int getFinalPosition(){
        return this.end;
    }
}
