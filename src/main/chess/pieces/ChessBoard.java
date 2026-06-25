package chess.pieces;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private ChessField[][] fields;
    private List<ChessPiece> pieces;

    public ChessBoard() {

        fields = new ChessField[8][8];
        pieces = new ArrayList<>();

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {

                ChessSprite.Color color;

                if ((x + y) % 2 == 0) {
                    color = ChessSprite.Color.WHITE;
                } else {
                    color = ChessSprite.Color.BLACK;
                }

                fields[x][y] = new ChessField(x, y, color);
            }
        }

        setupBoard();
    }

    private void setupBoard() {

        for (int x = 0; x < 8; x++) {

            pieces.add(new Pawn(this, x, 1, ChessSprite.Color.BLACK));

            pieces.add(new Pawn(this, x, 6, ChessSprite.Color.WHITE));
        }



    }

    public ChessField[][] getFields() {
        return fields;
    }

    public List<ChessPiece> getPieces() {
        return pieces;
    }

    public void highlight(int x, int y) {
        fields[x][y].setHighlighted(true);
    }

    public void unhighlightAll() {

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {

                fields[x][y].setHighlighted(false);
            }
        }
    }


}