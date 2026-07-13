import java.util.List;

import model.Board;
import model.Dice;
import model.Player;
import service.Game;
import strategy.impl.DefaultTurnStrategy;
import strategy.impl.DefaultWinningStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        Dice dice = new Dice();
        Player p1 = new Player("1", "user1", 0, false);
        Player p2 = new Player("2", "user2", 0, false);
        Player p3 = new Player("3", "user3", 0, false);

        Board board = new Board(100, 5,4);

        List<Player> players = List.of(p1,p2,p3);
        Game game = new Game(players, board, dice, new DefaultTurnStrategy(players), new DefaultWinningStrategy(100));
        game.start();
    }
}
