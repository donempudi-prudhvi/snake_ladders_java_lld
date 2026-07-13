package model;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int size;
    private int nSnakes;
    private int nLadders;

    public int getSize() {
        return size;
    }

    private Map<Integer, Item> posToItemMap;
    private Set<Integer> uniqueNumbers;


    public Board(int size, int nSnakes, int nLadders) {
        this.size = size;
        this.nSnakes = nSnakes;
        this.nLadders = nLadders;
        posToItemMap = new HashMap<>();
        uniqueNumbers = new HashSet<>();


        for(int i=0;i<nSnakes;i++){
            int start = getUniqueNumber(20, size);
            int end = getUniqueNumber(1, start);
            posToItemMap.put(start, new Snake(start, end));
            LoggerClass.print("Placing Snake from " + start + " to " + end);
            uniqueNumbers.add(start);
            uniqueNumbers.add(end);

        }
        for(int i=0;i<nLadders;i++){
            int start = getUniqueNumber(1, size-20);
            int end = getUniqueNumber(start, size);
            posToItemMap.put(start, new Ladder(start, end));
            LoggerClass.print("Placing Ladder from " + start + " to " + end);
            uniqueNumbers.add(start);
            uniqueNumbers.add(end);

        }


    }
    private int getUniqueNumber(int startNumber, int lastNumer){

        int cell = ThreadLocalRandom.current().nextInt(startNumber,lastNumer+1);
        while(uniqueNumbers.contains(cell)){
            cell = ThreadLocalRandom.current().nextInt(startNumber,lastNumer+1);
        }
        return cell;

    }

    public void move(Player player, int move){
        int nextPos = player.getCurrentPos() + move;
        
        if(isValidMove(nextPos)){
            if(posToItemMap.containsKey(nextPos)){
                LoggerClass.print("Player "+ player.getUsername() +"Hit Item : " + nextPos);
                
                Item item = posToItemMap.get(nextPos);
                player.setCurrentPos(item.getFinalPosition());
            }else{
                player.setCurrentPos(nextPos);
            }
        LoggerClass.print(player.getUsername() + " is at " + player.getCurrentPos());

        }else{
            LoggerClass.print(player.getUsername() +" got an invalid position " + nextPos);
            //not a valid move - Pass
        }
    }
    private boolean isValidMove(int pos){
        return pos <= this.size;
    }   
    


    
}

