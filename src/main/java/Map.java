import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Getter
public class Map {

    private List<java.util.Map<Integer, Boolean>> rowList = new ArrayList<java.util.Map<Integer, Boolean>>();
    private int size;
    private String playerMoves;
    private Position startPlayerPosition;

    public Map(Scanner scanner) {
        String currentLine = scanner.nextLine();
        this.size = Integer.parseInt(currentLine.replaceAll("\\D", ""));
        if (size == 0) {
            throw new InvalidMapException("Map size can not be zero");
        }
        while (scanner.hasNext()) {
            currentLine = scanner.nextLine();
            if (currentLine.contains("R") || currentLine.contains("L") || currentLine.contains("U") || currentLine.contains("D")) {
                playerMoves = currentLine;
                break;
            }
            int columnNumber = 0;
            java.util.Map<Integer, Boolean> row = new HashMap<Integer, Boolean>();
            for (char lineChar : currentLine.toCharArray()) {

                switch (lineChar) {
                    case '0' :
                        row.put(columnNumber, false);
                        columnNumber++;
                        break;
                    case '1' :
                        row.put(columnNumber, true);
                        columnNumber++;
                        break;
                    case 'P' :
                        row.put(columnNumber, false);
                        columnNumber++;
                        startPlayerPosition = new Position(columnNumber - 1, rowList.size());
                }
            }
            if (row.size() != size) {
                throw new InvalidMapException("Not enough map elements");
            }
            rowList.add(row);
        }
        if (rowList.size() != size) {
            throw new InvalidMapException("Not enough map elements");
        }
    }

    public char getValueAt(int x, int y) {
        if (rowList.get(y).get(x)) {
            return '1';
        } else {
            return '0';
        }
    }

    public void print() {
        for (java.util.Map<Integer, Boolean> row : rowList) {
            row.forEach((key, value) -> System.out.print(value));
            System.out.println();
        }
    }
}
