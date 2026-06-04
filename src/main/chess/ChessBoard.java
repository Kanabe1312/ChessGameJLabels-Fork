package chess;

import chess.pieces.ChessField;
import chess.pieces.ChessPiece;
import chess.pieces.Pawn;

import java.util.ArrayList;

public class ChessBoard {
    private ArrayList<ChessPiece> pieces = new ArrayList<>();
    private ChessField[][] fields = new ChessField[8][8];

    public ChessBoard() {
        setupBoard();
    }

    private void setupBoard() {
        for(int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                fields[i][j] = new ChessField("resources/Chess_f" + (((i+j)%2==0)?"l":"d") + "t60.png", "resources/Chess_fat60.png", i, j);
            }
        }
        for(int i=0; i<8; i++) {
            pieces.add(new Pawn(this, i, 1, ChessPiece.Color.BLACK));
            pieces.add(new Pawn(this, i, 6, ChessPiece.Color.WHITE));
        }
    }

    public void highlight(int x, int y) {
        getFields()[x][y].setHighlighted(true);
    }

    public void unhighlightAll() {
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                getFields()[i][j].setHighlighted(false);
            }
        }
    }

    public ChessField[][] getFields() {
        return fields;
    }

    public ArrayList<ChessPiece> getPieces() {
        return pieces;
    }
}
