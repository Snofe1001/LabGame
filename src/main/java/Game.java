import java.util.ArrayList;
import java.util.List;

public class Game {

    private Map map;
    private List<Player> players = new ArrayList<Player>();

    public Game(Map map) {
        this.map = map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String playGameForPlayer(Player player) {
        if (!players.contains(player)) {
            return "Not found player for this game";
        }
        for (char moveStringChar : map.getPlayerMoves().toCharArray()) {
            switch (moveStringChar) {
                case 'L' :
                    player.moveLeft();
                    break;
                case 'R' :
                    player.moveRight();
                    break;
                case 'U' :
                    player.moveUp();
                    break;
                case 'D' :
                    player.moveDown();
                    break;
            }
        }
        return "Row: " + player.getPosition().getY() + "\nColumn: " + player.getPosition().getX();
    }
}
