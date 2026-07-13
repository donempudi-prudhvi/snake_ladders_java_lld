package strategy.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.LoggerClass;
import model.Player;
import strategy.TurnStrategy;

public class DefaultTurnStrategy implements TurnStrategy{

    public final Queue<Player> playerQueue;
    
    public DefaultTurnStrategy(List<Player> players){
        //LoggerClass.print("DefaultTurnStrategy Called");
        LoggerClass.print("Players size :" +players.size());

        this.playerQueue = new LinkedList<>(players);
    }

    @Override
    public Player getNextPlayer() {

        Player nextPlayer = playerQueue.poll();
        while(nextPlayer!=null && nextPlayer.isHasWon()){
            nextPlayer = playerQueue.poll();
        }
        playerQueue.offer(nextPlayer);
        return nextPlayer;
    }
    
    
}
