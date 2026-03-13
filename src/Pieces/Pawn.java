package Pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(String name, String color, int col, int row) {
        super(name, color, col, row);
    }

    public List<int[]> getPossibleMoves(List<Piece> pieces) {
        List<int[]> moves = new ArrayList<>();
        int direction = color.equalsIgnoreCase("white") ? -1 : 1; // white moves up, black moves down

        int nextRow = row + direction;
        int leftCol = col - 1;
        int rightCol = col + 1;

        // forward one square if empty
        boolean blocked = false;
        boolean leftTarget = false;
        boolean rightTarget = false;
        for (Piece p : pieces) {
            if (p.col == col && p.row == nextRow) {
                blocked = true;
                break;
            }
        }
        for (Piece p : pieces) {
            if (p.col == leftCol && p.row == nextRow && !p.color.equalsIgnoreCase(this.color)) {
                leftTarget = true;
                break;
            }
        }
        for (Piece p : pieces) {
            if (p.col == rightCol && p.row == nextRow && !p.color.equalsIgnoreCase(this.color)) {
                rightTarget = true;
                break;
            }
        }
        if (!blocked) {
            moves.add(new int[] { col, nextRow });
        }
        if (leftTarget) {
            moves.add(new int[] { leftCol, nextRow });
        }
        if (rightTarget) {
            moves.add(new int[] { rightCol, nextRow });
        }
        return moves;
    }
}
