package strategy.impl;

import model.Board;
import model.Player;
import strategy.WinStrategy;

public class DefaultWinningStrategy implements WinStrategy{

    private final int boardSize;
    
    public DefaultWinningStrategy(int boardSize){
        this.boardSize = boardSize;
    }
 
    @Override
    public boolean hasWon(Player player){
        return player.getCurrentPos()  == boardSize;
    }
    
}
