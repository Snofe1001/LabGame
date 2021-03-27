import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyPlayer implements Player {

    private Position position;
    private Map map;

    public void moveRight() {
        if (position.getX() < map.getSize() - 1) {
            if (!map.getRowList().get(position.getY()).get(position.getX() + 1)) {
                position.setX(position.getX() + 1);
            }
        }
    }

    public void moveLeft() {
        if (position.getX() > 0) {
            if (!map.getRowList().get(position.getY()).get(position.getX() - 1)) {
                position.setX(position.getX() - 1);
            }
        }

    }

    public void moveUp() {
        if (position.getY() > 0) {
            if (!map.getRowList().get(position.getY() - 1).get(position.getX())) {
                position.setY(position.getY() - 1);
            }
        }

    }

    public void moveDown() {
        if (position.getY() < map.getSize() - 1) {
            if (!map.getRowList().get(position.getY() + 1).get(position.getX())) {
                position.setY(position.getY() + 1);
            }
        }

    }
}
