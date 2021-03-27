import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map map = new Map(new Scanner(System.in));
        Player player = new MyPlayer(map.getStartPlayerPosition(), map);
        Game game = new Game(map);
        game.addPlayer(player);
        System.out.println(game.playGameForPlayer(player));
    }
}
