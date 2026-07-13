package service;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Dice;
import model.GameStatus;
import model.LoggerClass;
import model.Player;
import strategy.TurnStrategy;
import strategy.WinStrategy;

public class Game {

    private final List<Player> players;
    private final Board board;
    private final Dice dice;
    private final TurnStrategy turnStrategy;
    private final WinStrategy winStrategy;
    private GameStatus status;

    public Game(List<Player> players, Board board, Dice dice, TurnStrategy turnStrategy, WinStrategy winStrategy) {
        this.players = players;
        this.board = board;
        this.dice = dice;
        this.turnStrategy = turnStrategy;
        this.winStrategy = winStrategy;
        this.status = GameStatus.ACTIVE;
    }

    public void start(){
        
        LoggerClass.print("Game Started\n");

        //List<Player> playersCopy = new ArrayList<>(players);
        while(this.status!= GameStatus.ENDED){

            Player currentPlayer = turnStrategy.getNextPlayer();
            LoggerClass.print("Current Player is : " + currentPlayer.getUsername());
            if(currentPlayer!=null){
                int roll = currentPlayer.play(dice);
                LoggerClass.print("Current Player got " + roll);
                board.move(currentPlayer, roll);
                boolean hasWon = winStrategy.hasWon(currentPlayer);
                if(hasWon){
                    LoggerClass.print(currentPlayer.getUsername() + "  Has Won");
                    status = GameStatus.ENDED;
                }
            }
            LoggerClass.print("\n");
        }


    }

    
    


}
