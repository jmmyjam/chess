package Pieces;

import java.util.List;

interface Movement {
    List<int[]> getPossibleMoves(List<Piece> pieces);

    void setPosition(int col, int row);
}
